import java.io.*;
import java.nio.file.Files;

public class GetFile {
    
    public static void main(String[] args) {
        String source = "D:\\学习资料\\极客时间\\31-深入浅出计算机组成原理（完结）\\06-加餐 (1讲)";
        String dest = "D:\\dest";
        find(source, dest);

    }

    public static void find(String path, String dest) {
        File dirfile = new File(path);

        if (!dirfile.exists()) {
            System.out.println("not found dir/file!");
            System.out.println("hhh");
            return;
        }

        if (!dirfile.isDirectory()) {
            if (dirfile.isFile()) {
                return;
            }
        }

        String[] fileList = dirfile.list();

        for (int i = 0; i < fileList.length; i++) {
            String str = fileList[i];
            if (str.endsWith(".pdf")) {
                File source = new File(path + "\\" + str);
                File d = new File(dest + "\\" + str);
                try {
                    Files.copy(source.toPath(), d.toPath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            continue;
        }
    }

}
