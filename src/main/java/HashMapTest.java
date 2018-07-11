import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) throws IOException {
        System.out.println("データベースへのアクセスが完了しました。");
        System.out.println("名前問い合わせシステムを起動します:");
        System.out.println("Idまたは終了命令(end)を入力してください。");
        System.out.println("現在データベース上にある名前数:" + idMag.size());
        findId();
    }

    public static void returnFindId() throws IOException{
        findId();
    }

    public static void findId() throws IOException {
        int id = getId();
        if(id == -1) {
            System.out.println("Idまたはendを入力してください。");
            System.out.println("再度入力してください。(endで終了)");
            returnFindId();
        }
        if(id == -2) {
            System.exit(0);
        }

        if(idMag.get(id) == null) {
            System.out.println("問い合わせされたIdは登録されていませんでした。");
            System.out.println("再度入力してください。(endで終了)");
            returnFindId();
        }
        System.out.println("問い合わせされたIdに登録されている名前は" + idMag.get(id)+"でした。");
        System.out.println("再度入力してください。(endで終了)");
        returnFindId();
    }

    public static int getId() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String inputString = br.readLine();
        if(inputString.equalsIgnoreCase("end")){
            System.out.println("本日はシステムをご利用いただきましてありがとうございました。");
            return -2;
        }
        try{
            int i = Integer.parseInt(inputString);
            return i;
        } catch(NumberFormatException nfe) {
            return -1;
        }
    }

    public static Map<Integer, String> idMag = new HashMap<Integer, String>();
    static {
        idMag.put(1, "Mamizu0312");
        idMag.put(2, "Water_Devil_");
    }
}
