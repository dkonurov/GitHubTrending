package hram.githubtrending.data.model;

import android.support.annotation.NonNull;

import com.github.florent37.retrojsoup.annotations.JsoupHref;
import com.github.florent37.retrojsoup.annotations.JsoupText;

/**
 * @author Evgeny Khramov
 */
public class Language {

    @JsoupHref("a")
    String href;

    @JsoupText(".select-menu-item-text")
    String name;

    @NonNull
    public String getHref() {
        return href;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Language{" +
                "href='" + href + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
