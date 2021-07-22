package source;

import level.boardLevel;

public class Board
{
    int size;
    myCell[] cell;

    public Board(int size)
    {
        this.size = size;
        cell = new myCell[size * size];
        myCell.resetSwapPoint();

        int[] a = new boardLevel(size).getBoard();

        for(int i=0;i<size * size;i++)
        {
            cell[i] = new myCell(i,a[i]);
        }
    }

    public myCell getCell(int index)
    {
        return cell[index];
    }

    public int getSize()
    {
        return size;
    }

    public static int getStepCount(){
        return myCell.step;
    }

    public boolean isSolve()
    {
        for(int i=0;i<size*size;i++)
            if(cell[i].getRootId() != cell[i].getImageId())
                return false;
        //myCell.resetSwapPoint();
        return true;
    }
}
