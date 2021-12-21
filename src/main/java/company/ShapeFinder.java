package company;

import java.util.ArrayList;

public class ShapeFinder {
    public ShapeFinder(ArrayList<Cords> cords) {
        this.cords = cords;
    }

    private ArrayList<Cords> cords;
    private Cords c1, c2, c3, c4, c5, c6, c7, c8;
    private int gap1, gap2, gap3, gap4, gap5, gap6, gap7, gap8, gap9, gap10, gap11, gap12;

    public String name() {
        // String name = "";
        switch (cords.size()) {
            case 0:
                return "None";
                // break;
            case 1:
                return "Dot";
                // break;
            case 2:
                return "Line";
                // break;
            case 3:
                c1 = cords.get(0);
                c2 = cords.get(1);
                c3 = cords.get(2);

                if (cords.size() == 3 && !(c1 == c2) && !(c1 == c3) && !(c2 == c3)) {
                    return "Triangle";
                }
                // break;
            case 4:
                c1 = cords.get(0);
                c2 = cords.get(1);
                c3 = cords.get(2);
                c4 = cords.get(3);

                gap1 = distanceSquared(c1, c2);
                gap2 = distanceSquared(c2, c3);
                gap3 = distanceSquared(c3, c4);
                gap4 = distanceSquared(c4, c1);

                if (isSameGap(gap1, gap2, gap3, gap4)) {
                    return "Square";
                } else if (gap1 == gap3 || gap2 == gap4){
                    return "Rectangle";
                }
               // break;
            case 5:
                c1 = cords.get(0);
                c2 = cords.get(1);
                c3 = cords.get(2);
                c4 = cords.get(3);
                c5 = cords.get(4);

                gap1 = distanceSquared(c1, c2);
                gap2 = distanceSquared(c2, c3);
                gap3 = distanceSquared(c3, c4);
                gap4 = distanceSquared(c4, c1);

                if ((isSameGap(gap1, gap2, gap3, gap4)) || (gap1 == gap3 || gap2 == gap4)) {
                    if (c5.z > c1.z || c5.z > c2.z || c5.z > c3.z || c5.z > c4.z) {
                        return "Pyramid";
                    }
                }
                //break;
            case 8:
                c1 = cords.get(0);
                c2 = cords.get(1);
                c3 = cords.get(2);
                c4 = cords.get(3);
                c5 = cords.get(4);
                c6 = cords.get(5);
                c7 = cords.get(6);
                c8 = cords.get(7);

                gap1 = distanceSquared(c1, c2);
                gap2 = distanceSquared(c2, c3);
                gap3 = distanceSquared(c3, c4);
                gap4 = distanceSquared(c4, c1);
                gap5 = distanceSquared(c5, c6);
                gap6 = distanceSquared(c6, c7);
                gap7 = distanceSquared(c7, c8);
                gap8 = distanceSquared(c8, c5);
                gap9 = distanceSquared(c1, c5);
                gap10 = distanceSquared(c2, c6);
                gap11 = distanceSquared(c3, c7);
                gap12 = distanceSquared(c4, c8);

                if (isSameGap(gap1, gap2, gap3, gap4, gap5, gap6, gap7, gap8, gap9, gap10, gap11, gap12)) {
                    return "Cube";
                } else if ((gap1 == gap3 || gap2 == gap4) && (gap5 == gap6 || gap7 == gap8) && isSameGap(gap9, gap10, gap11, gap12)) {
                    return "Rectangular Prism";
                }
                //break;
        }

        int dimension = getDimension();
        if (dimension == 2) {
            return "2D Shape";
        } else if (dimension == 3) {
            return "3D Shape";
        }

        return "error";
    }

    private boolean isSameGap(int... gap) {
        for (int i = 1; i < gap.length; i++) {
            int first = gap[i - 1];
            int second = gap[i];
            if (first != second) {
                return false;
            }
        }
        return true;
    }

    private int distanceSquared(Cords a, Cords b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y) + (a.z - b.z) * (a.z - b.z);
    }

    private int getDimension() {
        int x = 0, y = 0, z = 0;

        for (Cords cords1 : cords) {
            if (cords1.x != 0) {
                x = 1;
            }

            if (cords1.y != 0) {
                y = 1;
            }

            if (cords1.z != 0) {
                z = 1;
            }
        }
        return x + y + z;
    }
}
