#include <stdio.h>

double c[100];

double func(int n, double x){
    double ans=0;
    int i, j;
    for(i=0; i<n; i++){
        double tmp;
        tmp = c[i];
        for(j=0;j<i;j++){
            tmp *= x;
        }
        ans += tmp;
    }
    return ans;
}

int main(void){
    int n, i;
    scanf("%d", &n);
    for(i=0;i<n;i++){
        scanf("%lf", &c[i]);
    }
    for(i=1;i<=30;i++){
        double x;
        x = 0.1*i;
        printf("x:%lf y:%lf\n", x, func(n, x));
    }
    return 0;
}