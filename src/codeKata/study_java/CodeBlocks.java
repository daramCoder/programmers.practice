package codeKata.study_java;

public class CodeBlocks {

    private static String aField =
        "";
    private String bField =
        "";
    static {
        aField += "A";
    }

    public CodeBlocks() {
        aField += "C";
        bField += "C";
    }
    {
        aField += "B";
        bField += "B";
    }
    public void append() {
        aField += "D";
        bField += "D";
    }
    public static void main(String[] argv) {
        System.out.println(aField  + " (aField)");
        CodeBlocks cb = new CodeBlocks();
        cb.append();
        System.out.println(aField  + " (cb.append 후 aField)");
        System.out.println(cb.bField);
    }
}