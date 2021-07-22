package source;

public class myCell {
    int rootId; // ID gốc của phần tử
    int imageId; // ID ảnh của phần tử
    public static int step; //Số lần hóa đổi mỗi phần tử

    public myCell(int rootId, int imageId)
    {
        this.rootId = rootId;
        this.imageId = imageId;
    }

    public myCell(){}

    public int getImageId()
    {
        return imageId;
    }

    public void setImageId(int id) {

        this.imageId = id;
    }

    public int getRootId()
    {
        return rootId;
    }

    public void setRootId(int id) {
            this.rootId = id;
    }

    // Hoán đổi 2 phần tử
    public void swapTo(myCell cell_2)
    {
        step++;
        int temp = cell_2.getImageId();
        cell_2.setImageId(this.imageId);
        this.imageId = temp;
    }

    // Đặt lại số lần hoán đổi
    public static void resetSwapPoint(){
        step = 0;
    }
}
