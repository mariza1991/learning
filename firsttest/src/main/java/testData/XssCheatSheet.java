package testData;

public class XssCheatSheet {

    public final static String[] myArr = {
            "<scripr>alert(\"some text test me\");</script>",
            "<scripr>alert(\"xx\");</script>",
            "345"
    };
}
