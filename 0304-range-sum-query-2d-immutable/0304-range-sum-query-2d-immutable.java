class NumMatrix {
      int matrix[][];
      int psum[][];
    public NumMatrix(int[][] matrix) 
    {
        this.matrix=matrix;
        initialisePsum();
    }
    


     public void initialisePsum()
     {
           psum= new int [matrix.length][matrix[0].length];
           psum[0][0]=matrix[0][0];

           for(int r=1;r<matrix.length;r++ )  // addding rows 
           {
                  psum[r][0]= psum[r-1][0]+matrix[r][0];
           }
          
          for(int c=1;c<matrix[0].length;c++ )  // addding for cols
           {
                  psum[0][c]= psum[0][c-1]+matrix[0][c];
           }

            // for rest of the matrix 

            for(int r=1;r<matrix.length;r++)
            {
                for(int c=1;c<matrix[0].length;c++)
                {
                     psum[r][c] =   psum[r-1][c] + psum[r][c-1] - psum[r-1][c-1] + matrix[r][c];
                }
            }


           
     }




    public int sumRegion(int row1, int col1, int row2, int col2) 
    {

         int s= getElement(row2,col2);
         int a=getElement(row1-1,col2);
         int b=getElement(row2,col1-1);
         int c=getElement(row1-1,col1-1);

        return s-a-b+c;
    }



    public int getElement(int r,int c)
    {
        if(r<0 || c<0)
        {
              return 0;
        }

        return psum[r][c];
    }
}

