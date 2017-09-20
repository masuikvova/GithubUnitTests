package ru.arturvasilov.githubmvp.screen.repositories;

import android.support.annotation.NonNull;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import ru.arturvasilov.githubmvp.test.MockLifecycleHandler;
import ru.arturvasilov.githubmvp.test.TestGithubRepository;
import ru.arturvasilov.rxloader.LifecycleHandler;
import ru.gdgkazan.githubmvp.content.Repository;
import ru.gdgkazan.githubmvp.repository.RepositoryProvider;
import ru.gdgkazan.githubmvp.screen.repositories.RepositoriesPresenter;
import ru.gdgkazan.githubmvp.screen.repositories.RepositoriesView;
import rx.Observable;

/**
 * @author Artur Vasilov
 */
@RunWith(JUnit4.class)
public class RepositoriesPresenterTest {

    /**
     * TODO : task
     * <p>
     * Create tests for {@link ru.gdgkazan.githubmvp.screen.repositories.RepositoriesPresenter}
     * <p>
     * Your test cases must have at least 3 tests
     */

    private RepositoriesView view;
    private RepositoriesPresenter presenter;

    @Before
    public void setUp() {
        LifecycleHandler lifecycleHandler = new MockLifecycleHandler();
        view = Mockito.mock(RepositoriesView.class);
        presenter = new RepositoriesPresenter(lifecycleHandler, view);
    }

    @Test
    public void createPresenter() throws Exception {
        Assert.assertNotNull(presenter);
    }

    @Test
    public void loadData() throws Exception {
        RepositoryProvider.setGithubRepository(new TestGithubRepository());

        presenter.init();
        Mockito.verify(view).showLoading();
        Mockito.verify(view).hideLoading();
        Mockito.verify(view).showRepositories(new ArrayList<>());
    }

    @Test
    public void loadError() throws Exception {
        RepositoryProvider.setGithubRepository(new ErrorRepository());

        presenter.init();
        Mockito.verify(view).showLoading();
        Mockito.verify(view).hideLoading();
        Mockito.verify(view).showError();
    }

    @Test
    public void onItemClick() throws Exception {
        RepositoryProvider.setGithubRepository(new TestGithubRepository());
        Repository repository = new Repository();

        presenter.init();
        presenter.onItemClick(repository);

        Mockito.verify(view).showCommits(repository);
    }

    private class ErrorRepository extends TestGithubRepository {
        @NonNull
        @Override
        public Observable<List<Repository>> repositories() {
            return Observable.error(new Throwable());
        }
    }
}
