package rrr;

public class StandardLookupDemoBean implements DemoBean {
    private MyHelper myHelper;

    @Override
    public MyHelper getMyHelper() {
        return myHelper;
    }

    @Override
    public void someOperation() {
        myHelper.doSomethingHelpful();
    }

    public void setMyHelper(MyHelper myHelper) {
        this.myHelper = myHelper;
    }
}
