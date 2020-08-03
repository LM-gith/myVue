import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @author luoming
 * @date 2020/5/18
 */
public class Filetest {
    public static void main(String[] args) throws Exception{

        String path = "C:\\Users\\luoming\\Desktop\\采集5.18错误数据\\T_SCLD_RYCGXXerrorinfo.txt";
        //win系统
//        String path = "c:\\hello.txt";
        FileInputStream fileInputStream = new FileInputStream(path);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

        String line = bufferedReader.readLine();
        int charread  = 0;
        while ((charread  = bufferedReader.read()) != -1) {

            if ((char) charread == 'z') {
                charread  = bufferedReader.read();
                if((char) charread == 'b'){
                    for(int i = 0;i < 9;i++){
                        charread  = bufferedReader.read();
                    }
                }

                charread  = bufferedReader.read();
                System.out.print("\n");

            }else{
                System.out.print((char) charread);
            }
        }
        fileInputStream.close();

    }

}
