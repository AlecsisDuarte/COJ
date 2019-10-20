#include <stdio.h>
#include <math.h>
#include <string.h>

#define MAX_LENGTH 101

int main()
{
    char word[MAX_LENGTH];
    int len, middle, index;

    scanf("%s", word);
    len = strlen(word);

    char encrypted[len + 1];
    middle = len / 2;
    index = 0;

    for (int i = middle - 1; i >= 0; i--)
        encrypted[index++] = word[i];

    if (len % 2 == 1)
        middle += 1;

    for (int i = len - 1; i >= middle; i--)
        encrypted[index++] = word[i];

    printf("%s\n", encrypted);

    return 0;
}