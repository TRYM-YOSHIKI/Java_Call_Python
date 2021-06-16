import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;

public class Call_Python {
    public static void Call_py() throws IOException {
        //pythonに渡す引数
        String arg = "テスト";

        // 実行する外部プログラムを指定してProcessBuilderインスタンスを生成する
        ProcessBuilder p = new ProcessBuilder("python", "test.py", arg);
        p.redirectErrorStream(true);

        ArrayList<String> hoge = new ArrayList<String>();
        try {
            // プロセスを開始する
            Process process = p.start();

            // 結果を受け取る
            try (BufferedReader r = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = r.readLine()) != null) {
                    //System.out.println(line);
                    hoge.add(line);
                }
            }
            
            try {
                process.waitFor();
            } catch (InterruptedException ee) {
                ee.printStackTrace();
            }
            
            process.exitValue();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
