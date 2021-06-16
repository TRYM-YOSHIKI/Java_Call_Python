import java.io.IOException;

public class Call_Python_None_arg {
    public static void Call_py() throws IOException {
        // 実行する外部プログラムを指定してProcessBuilderインスタンスを生成する
        ProcessBuilder processBuilder = new ProcessBuilder("python", "test.py");
        // プロセスを開始する
        Process process = processBuilder.start();
        try {
            process.waitFor();
        } catch (InterruptedException ee) {
            ee.printStackTrace();
        }
        process.exitValue();
    }
}