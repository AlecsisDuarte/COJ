#include <stdio.h>
/**
WRONG ANSWER
**/
int main(){
  char num[1002];
  unsigned short t;
  scanf("%hu",&t);
  while(t--){
    _Bool n=0;
    scanf("%s",num);
    int i=0;
    while(num[i]!='\0'){
      if(num[i]>'0')n=1;
      ++i;
    }
    --i;
    (num[i]=='5'||(num[i]=='0'&&n))?printf("YES\n"):printf("NO\n");
  }
  return 0;
}
