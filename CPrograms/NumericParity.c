#include <stdio.h>
/*
Devuelve un WRONG ANSWER
debe de imprimir:
"The parity of B is P (mod 2)."
where B is the binary representation of I.
*/
int main(){
  int dec=0;
  _Bool bin[32];
  do{
    if(dec){
      int con=0, i=32;
      while(dec){
        if(dec&1){
          ++con;
          bin[--i]=1;
        }else{
          bin[--i]=0;
        }
        dec>>=1;
      }
      printf("The parity of ");
      for(;i<32;i++){
        printf("%i",bin[i]);
      }
      printf(" is %d (mod 2).\n",con);
    }
    scanf("%d",&dec);
  }while(dec!=0);
  return 0;
}
