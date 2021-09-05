package ui.utility.page_object_utils;

public interface PageObject {

    boolean isPageLoaded();

    void navigateToPage();

    boolean isPageTitleValid(String title);

}
