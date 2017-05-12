package hram.githubtrending.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.NonNull;

import org.jetbrains.annotations.Contract;

import hram.githubtrending.model.LanguageModel;

/**
 * @author Evgeny Khramov
 */
public class LanguageViewModel extends BaseObservable {

    @Bindable
    private String mName;

    @Bindable
    private String mHref;

    @Contract("_ -> !null")
    public static LanguageViewModel create(@NonNull LanguageModel model) {
        return new LanguageViewModel(model);
    }

    private LanguageViewModel(@NonNull LanguageModel model) {
        mName = model.getName();
        mHref = model.getHref();
    }

    public String getName() {
        return mName;
    }

    public String getHref() {
        return mHref;
    }

    @Override
    public String toString() {
        return "LanguageViewModel{" +
                "mName='" + mName + '\'' +
                ", mHref='" + mHref + '\'' +
                '}';
    }
}
