package com.github.dreamhead.moco;

import com.google.common.base.Optional;

public abstract class HttpRequestExtractor<T> implements RequestExtractor<T> {
    protected abstract Optional<T> doExtract(final HttpRequest request);

    public Optional<T> extract(final Request request) {
        if (HttpRequest.class.isInstance(request)) {
            return doExtract(HttpRequest.class.cast(request));
        }

        return Optional.absent();
    }
}
