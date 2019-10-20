#include <stdio.h>

int main(){
    float resul = 0;
    for(int x = 0; x<12; x++){
      float number;
      scanf("%f",&number);
      resul+=number;
    }
    resul /=12;
    printf("$%0.2f\n",resul);
    return 0;
}
