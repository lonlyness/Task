double calcu_determinant(int n){
        double det=1.0, buf;
        int i,j,k;
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                if(i<j){
                    buf=tmp2[j][i]/tmp2[i][i];
                    for(k=0;k<n;k++){
                        tmp2[j][k]-=tmp2[i][k]*buf;
                    }
                }
            }
        }
    for(i=0;i<n;i++){
        det*=tmp2[i][i];
    }
    
    return det;
}