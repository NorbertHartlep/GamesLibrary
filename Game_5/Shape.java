package Game_5;

import java.util.Random;

public class Shape {
    protected enum Tet {NoShape, ZShape, SShape,
        LineShape, TShape, SquareShape, Lshape, MirroredShape}

    private Tet pieceShape;
    private int coords[][];
    private int[][][] coordsTable;

    public Shape(){
        initShape();
    }

    private void initShape(){
        coords = new int[4][2];

        coordsTable = new int[][][]{
                { { 0, 0 },   { 0, 0 },   { 0, 0 },   { 0, 0 } },
                { { 0, -1 },  { 0, 0 },   { -1, 0 },  { -1, 1 } },
                { { 0, -1 },  { 0, 0 },   { 1, 0 },   { 1, 1 } },
                { { 0, -1 },  { 0, 0 },   { 0, 1 },   { 0, 2 } },
                { { -1, 0 },  { 0, 0 },   { 1, 0 },   { 0, 1 } },
                { { 0, 0 },   { 1, 0 },   { 0, 1 },   { 1, 1 } },
                { { -1, -1 }, { 0, -1 },  { 0, 0 },   { 0, 1 } },
                { { 1, -1 },  { 0, -1 },  { 0, 0 },   { 0, 1 } }
        };
        setShape(Tet.NoShape);
    }

    protected void setShape(Tet shape){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                coords[i][j] = coordsTable[shape.ordinal()][i][j];
            }
        }

        pieceShape = shape;
    }
    public void setX(int index, int x) {coords[index][0] = x;}
    public void setY(int index, int y) {coords[index][1] = y;}
    public int x(int index){return coords[index][0];}
    public int y(int index){return coords[index][1];}
    public Tet getShape(){return pieceShape;}

    public void setRandomShape(){
        var r = new Random();
        int x = Math.abs(r.nextInt()) %7 +1;

        Tet[] values = Tet.values();
        setShape(values[x]);
    }
    
    public int minX(){
        int m = coords[0][0];
        for (int i = 0; i < 4; i++) {
            m = Math.min(m, coords[i][0]);
        }
        return m;
    }

    public int minY(){
        int m = coords[0][1];

        for (int i = 0; i < 4; i++) {
            m = Math.min(m, coords[i][1]);
        }
        return m;
    }

    public Shape rotateLeft(){
        if(pieceShape == Tet.SquareShape){
            return this;
        }
        var result = new Shape();
        result.pieceShape = pieceShape;

        for (int i = 0; i < 4; i++) {
            result.setX(i,y(i));
            result.setY(i,-x(i));
        }
        return result;
    }

    public Shape rotateRight(){
        if(pieceShape == Tet.SquareShape){
            return this;
        }
        var result = new Shape();
        result.pieceShape = pieceShape;

        for (int i = 0; i < 4; i++) {
            result.setX(i,-y(i));
            result.setY(i,x(i));
        }
        return result;
    }
}
