public class Gauss {
    public static void f(Matrix m){
        if(m.row < m.col-1){
            System.out.println("Tidak dapat mencari solusi SPL.");
        } else {
            for(int i=0;i<m.row;i++){
                if(m.elmt(i, i) != 1){
                    for(int j=i+1;j<m.row;j++){
                        if(m.elmt(j, i) == 1){
                            m.swapRow(i,j);
                            break;
                        }
                    }
                }
                if(m.elmt(i, i) == 0){
                    for(int j=i+1;j<m.row;j++){
                        if(m.elmt(j, i) != 0){
                            m.swapRow(i,j);
                            break;
                        }
                    }
                }
                if(m.elmt(i, i) != 0){
                    m.timeRow(i, 1/m.elmt(i, i));
                    for(int j=i+1;j<m.row;j++){
                        m.addRow(j, i, -1*(m.elmt(j, i)/m.elmt(i, i)));
                    }
                }
                m.displayMatrix();
                System.out.println("");
            }
        }
    }

    public static void main(String[] args){
        Matrix m = new Matrix(4, 5);
        // m.readMatrix();
        m.displayMatrix();
        System.out.println("");
        Gauss.f(m);
        m.displayMatrix();
    }
}
/*
1 1 1 0
2 3 1 1
3 1 2 1
 */