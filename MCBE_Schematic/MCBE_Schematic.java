package MCBE_Schematic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class MCBE_Schematic {
    private int xSize;
    private int ySize;
    private int zSize;
    private Block[][][] block;

    public MCBE_Schematic(int xSize, int ySize, int zSize) {
        this.xSize = testSizeValue(xSize);
        this.ySize = testSizeValue(ySize);
        this.zSize = testSizeValue(zSize);

        block = new Block[xSize][ySize][zSize];

        for (int x = 0; x < xSize; x++) {
            for (int y = 0; y < ySize; y++) {
                for (int z = 0; z < zSize; z++) {
                    block[x][y][z] = new Block();
                }
            }
        }

    }

    public void setBlockType(int x, int y, int z, String blockType) {
        x = testCordValue(x, xSize);
        y = testCordValue(y, ySize);
        z = testCordValue(z, zSize);
        block[x][y][z].setName(blockType);
    }

    public void printConsole() {
        System.out.println("{format_version:1,size:[" + xSize + "," + ySize + "," + zSize + "],structure:{block_indices:[[0],[-1]],entities:[],palette:{default:{block_palette:[{name:\"minecraft:" + block[0][0][0].getBlockName() + "\",states:{},version:18108419}],block_position_data:{}}}},structure_world_origin:[0,0,0]}");
    }

    public void printFile() {
        try {
            PrintWriter file = new PrintWriter(new BufferedWriter(new FileWriter("Output")));
            file.println("{format_version:1,size:[" + xSize + "," + ySize + "," + zSize + "],structure:{block_indices:[[0],[-1]],entities:[],palette:{default:{block_palette:[{name:\"minecraft:" + block[0][0][0].getBlockName() + "\",states:{},version:18108419}],block_position_data:{}}}},structure_world_origin:[0,0,0]}");
            file.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private int testCordValue(int cord, int size) {
        if (cord >= size) {
            System.out.println("Coordinate: " + cord + " was bigger than structure dimension: " + size);
            cord = size - 1;
        } else if (cord < 0) {
            System.out.println("Coordinate: " + cord + " was smaller than 0");
            cord = 0;
        }
        return cord;
    }

    private int testSizeValue(int size){
        if (size < 1){
            System.out.println("Structure dimension: " + size + " was smaller than 1");
            size = 1;

        }
        return size;
    }
}
