package MCBE_Schematic;

public class Block {
    private String blockName;
    private String blockState;

    public Block(){
        blockName = "air";
        blockState = "";
    }

    public void setName(String name){
        blockName = name;
    }

    public void setState(String state){
        blockState = state;
    }

    public String getBlockName() {
        return blockName;
    }

    public String getBlockState() {
        return blockState;
    }
}
