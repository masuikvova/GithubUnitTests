package ru.arturvasilov.githubmvp.screen.walkthrough;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

import java.util.ArrayList;

import ru.arturvasilov.githubmvp.test.TestKeyValueStorage;
import ru.gdgkazan.githubmvp.content.Benefit;
import ru.gdgkazan.githubmvp.repository.KeyValueStorage;
import ru.gdgkazan.githubmvp.repository.RepositoryProvider;
import ru.gdgkazan.githubmvp.screen.walkthrough.WalkthroughPresenter;
import ru.gdgkazan.githubmvp.screen.walkthrough.WalkthroughView;

/**
 * @author Artur Vasilov
 */
@RunWith(JUnit4.class)
public class WalkthroughPresenterTest {

    /**
     * TODO : task
     * <p>
     * Create tests for {@link ru.gdgkazan.githubmvp.screen.walkthrough.WalkthroughPresenter}
     * <p>
     * Your test cases must have at least 6 small tests and 1 large test (for some interaction scenario for this screen)
     */
    private static final int PAGES_COUNT = 3;
    private static final int RES_ID = 2131099695;
    private WalkthroughView view;
    private WalkthroughPresenter presenter;

    @Before
    public void setUp() {
        view = Mockito.mock(WalkthroughView.class);
        presenter = new WalkthroughPresenter(view);
    }

    @Test
    public void createPresenter() throws Exception {
        Assert.assertNotNull(presenter);
    }

    @Test
    public void testNoActionsWithView() throws Exception {
        Mockito.verifyNoMoreInteractions(view);
    }

    @Test
    public void testPassed() throws Exception {
        KeyValueStorage storage = new KeyStorage(true);
        RepositoryProvider.setKeyValueStorage(storage);
        presenter.init();

        Mockito.verify(view).startAuth();
    }

    @Test
    public void notPassed() throws Exception {
        KeyValueStorage storage = new KeyStorage(false);
        RepositoryProvider.setKeyValueStorage(storage);
        presenter.init();
        Mockito.verify(view).showBenefits(new ArrayList<Benefit>() {
            {
                add(Benefit.WORK_TOGETHER);
                add(Benefit.CODE_HISTORY);
                add(Benefit.PUBLISH_SOURCE);
            }
        });
        Mockito.verify(view).showActionButtonText(RES_ID);
    }

    @Test
    public void testChangePage() {
        KeyValueStorage storage = new TestKeyValueStorage();
        RepositoryProvider.setKeyValueStorage(storage);
        presenter.init();
        for (int i = 0; i < PAGES_COUNT; i++) {
            presenter.onPageChanged(i, true);
        }
        Mockito.verify(view,Mockito.times(3)).showActionButtonText(RES_ID);
    }
    @Test
    public void testChangePageNotUser() {
        KeyValueStorage storage = new TestKeyValueStorage();
        RepositoryProvider.setKeyValueStorage(storage);
        presenter.init();
        for (int i = 0; i < PAGES_COUNT; i++) {
            presenter.onPageChanged(i, false);
        }
        Mockito.verify(view,Mockito.times(1)).showActionButtonText(RES_ID);
    }

    @Test
    public void testOpenAuthScreen() throws Exception {
        KeyValueStorage storage = new TestKeyValueStorage();
        RepositoryProvider.setKeyValueStorage(storage);
        presenter.init();
        for (int i = 0; i < PAGES_COUNT; i++) {
            presenter.onActionButtonClick();
        }
        Mockito.verify(view, Mockito.times(2)).scrollToNextBenefit();
        Mockito.verify(view).startAuth();
    }


    private class KeyStorage extends TestKeyValueStorage {
        private boolean isPassed = false;

        public KeyStorage(boolean isPassed) {
            this.isPassed = isPassed;
        }

        @Override
        public boolean isWalkthroughPassed() {
            return isPassed;
        }
    }

}
