class Spreadsheet {

    int [][] sheet;
    public Spreadsheet(int rows) {
        sheet = new int [rows][26];
    }
    
    public void setCell(String cell, int value) {
        int [] cellNum = getCell(cell);

        sheet[cellNum[0]][cellNum[1]] = value;
    }
    
    public void resetCell(String cell) {
        int [] cellNum = getCell(cell);

        sheet[cellNum[0]][cellNum[1]] = 0;
    }
    
    public int getValue(String formula) {
        String [] cells = formula.substring(1).split("\\+");
        int sum = 0;

        for(int i=0;i<2;i++){
            if(isChar(cells[i].charAt(0))){
                int [] cellNum = getCell(cells[i]);

                sum += sheet[cellNum[0]][cellNum[1]];
            }
            else{
                sum += Integer.parseInt(cells[i]);
            }
        }

        return sum;
    }

    public boolean isChar(char ch){
        return ch >= 'A' && ch <= 'Z';
    }

    public int [] getCell(String cell){
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;

        return new int [] {row, col};
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */