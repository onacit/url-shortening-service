package org.bitbucket.onacit.musinsaurlshorteningservice.web.bind;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bitbucket.onacit.musinsaurlshorteningservice.data.jpa.domain.ShortenedUrl;
import org.bitbucket.onacit.musinsaurlshorteningservice.sterotype.UrlShorteningService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller
@RequestMapping(path = "/")
@RequiredArgsConstructor
@Slf4j
public class UrlShorteningController {

    private static final String ATTRIBUTE_NAME_SHORTENED_URL = "shortenedUrl";

    private static final String ATTRIBUTE_NAME_SHORTENED_URL_FORM = "shortenedUrlForm";

    /**
     * Reads the initial page.
     *
     * @param model a model.
     * @return initial page name.
     */
    @GetMapping(path = "/")
    public String index(final Model model) {
        model.addAttribute(ATTRIBUTE_NAME_SHORTENED_URL_FORM, new ShortenedUrlForm());
        return "shorten";
    }

    /**
     * Shortens a submitted URL.
     *
     * @param model            a model
     * @param shortenedUrlForm a submitted form whose {@code originalUrl} is shortened.
     * @param bindingResult    a binding result.
     * @return a name of the result page.
     */
    @PostMapping(path = "/shorten")
    public String shorten(
            final Model model,
            final @Valid @NotNull @ModelAttribute(ATTRIBUTE_NAME_SHORTENED_URL_FORM) ShortenedUrlForm shortenedUrlForm,
            final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "shorten";
        }
        final ShortenedUrl shortenedUrl = urlShorteningService.shorten(shortenedUrlForm.getOriginalUrl());
        final ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentContextPath();
        builder.pathSegment("widen");
        builder.pathSegment(shortenedUrl.getShortenedId());
        shortenedUrl.setShortenedUrl(builder.build().toUriString());
        model.addAttribute(ATTRIBUTE_NAME_SHORTENED_URL, shortenedUrl);
        return "shortened";
    }

    /**
     * Widen, actually redirects to, the original URL in specified shortened identifier.
     *
     * @param shortenedId the shortened identifier whose original URL is redirected.
     * @return a redirect view.
     */
    @GetMapping(path = "/widen/{shortenedId:.+}")
    public RedirectView widen(final @PathVariable("shortenedId") String shortenedId) {
        return urlShorteningService.widen(shortenedId)
                .map(e -> {
                    final RedirectView redirectView = new RedirectView();
                    redirectView.setUrl(e.getOriginalUrl());
                    return redirectView;
                })
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    private final UrlShorteningService urlShorteningService;
}
