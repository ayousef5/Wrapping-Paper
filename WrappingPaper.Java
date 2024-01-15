import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class WrappingPaper
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a filename: ");
        String fileName = input.nextLine();
        
        ArrayList<String> lines = getInput(fileName);
        
        // This loop reads one line of the file in
        // each pass
         int totalSurfaceArea = 0;
        int totalRolls = 0;

        for (String line : lines) {
            String[] dimensions = line.split("x");

            if (dimensions.length == 3) {
                int length = Integer.parseInt(dimensions[0]);
                int width = Integer.parseInt(dimensions[1]);
                int height = Integer.parseInt(dimensions[2]);

                // Calculate surface area for the rectangular prism
                int surfaceArea = 2 * (length * width + width * height + height * length);
                totalSurfaceArea += surfaceArea;
            } else if (dimensions.length == 1) {
                int sideLength = Integer.parseInt(dimensions[0]);

                // For a perfect cube, length = width = height
                int surfaceArea = 6 * (sideLength * sideLength);
                totalSurfaceArea += surfaceArea;
            }
        }

        // Calculate the number of rolls needed
        totalRolls = (int) Math.ceil(totalSurfaceArea / (180.0 * 144));


        // Print the results
        System.out.println("Total Wrapping Paper: " + totalSurfaceArea);
        System.out.println("Total Rolls of Paper: " + totalRolls);
    }
    
    private static ArrayList<String> getInput(String file) {
        ArrayList<String> lines = new ArrayList<String>();
        try {
            Scanner fileIn = new Scanner(new File(file));
            while (fileIn.hasNext()) {
                lines.add(fileIn.nextLine()); 
            }
        }
        catch (IOException e) {
            System.out.println("File not found");
        }
        return lines;
    }
}
