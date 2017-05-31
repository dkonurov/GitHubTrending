package hram.githubtrending.splash;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.List;

import hram.githubtrending.data.DataManager;
import hram.githubtrending.viewmodel.LanguageViewModel;
import hram.githubtrending.viewmodel.RepositoriesViewModel;
import hram.githubtrending.viewmodel.SplashViewModel;
import hram.githubtrending.viewmodel.TimeSpanViewModel;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Evgeny Khramov
 */
@InjectViewState
public class SplashPresenter extends MvpPresenter<SplashView> {

    SplashViewModel mSplashViewModel;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

        mSplashViewModel = new SplashViewModel();
        getViewState().setViewModel(mSplashViewModel);

        if (DataManager.getInstance().getParams().isEmpty()) {
            Observable.zip(DataManager.getInstance().getLanguages(), DataManager.getInstance().getTimeSpans(), this::checkIfNotEmpty)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(this::handleResult, this::handleError);
        } else {
            getViewState().openTrendsScreen();
        }
    }

    private void handleResult(boolean res) {
        if (res) {
            getViewState().openFilterScreen();
        } else {

        }
    }

    private void handleError(@NonNull Throwable throwable) {

    }

    private boolean checkIfNotEmpty(List<LanguageViewModel> languages, List<TimeSpanViewModel> timeSpans) {
        return !languages.isEmpty() && !timeSpans.isEmpty();
    }
}