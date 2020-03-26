import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Hetman {
    public static final String PATH = "resources/hetmanfinal.jpg";
    private static int width;
    private static int height;
    private static final int TABLE_WIDTH = 8;
    private static BufferedImage image;

    public static void main(String[] args) {
        try {
            start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void start() throws IOException {
        File file = new File(PATH);
        image = ImageIO.read(file);
        width = image.getWidth();
        height = image.getHeight();
        System.out.println(width);
        System.out.println(height);
        int[] a = startAndEndPoint();
        int firstLine = a[0];
        int lastLine = a[1];
        processImage(firstLine, lastLine);
    }


    private static int[] startAndEndPoint() {
        Scanner scanner = new Scanner(System.in);
        int[] a = new int[2];
        System.out.println("pass first and last line");
        a[0] = scanner.nextInt();
        a[1] = scanner.nextInt();
        return a;
    }

    private static void processImage(int firstLine, int lastLine) {
        Scanner scanner = new Scanner(System.in);
        for (int i = firstLine; i <= lastLine; ++i) {
            processLine(width, i);
            System.out.println("if you want to go the next line press n");
            String s = "";
            while (!s.equalsIgnoreCase("n"))
                s = scanner.nextLine();
        }

    }

    private static void processLine(int width, int currentLine) {
        int a = width / TABLE_WIDTH;
        for (int i = 0; i < a; ++i) {
            for (int j = 0; j < TABLE_WIDTH; ++j)
                printColor(i, j, currentLine);
            System.out.println(i);
        }

    }

    private static void printColor(int i, int j, int currentLine) {
        //System.out.println(currentLine + "  " + i*width + j);
        int rgb = image.getRGB(currentLine, i * TABLE_WIDTH + j);
        Color color = new Color(rgb);
        getColor(color);


    }

    private static void getColor(Color color) {
        int green = color.getGreen();
        if (green == Color.WHITE.getGreen())
            System.out.print("WHITE ");
        else if (green == Color.LIGHT_GRAY.getGreen())
        System.out.print("LIGHT_GRAY ");
        else if(green == Color.GRAY.getGreen())
        System.out.print("GRAY ");
        else if(green == Color.DARK_GRAY.getGreen())
        System.out.print("DARK_GRAY ");
        else if(green == Color.BLACK.getGreen())
        System.out.println("BLACK ");
        System.out.println();
    }
}


