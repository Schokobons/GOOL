
int main(int a) {
	id unObjet = nil;
	char* b;
	if(a + 3 == 5 + 10) {
		a = (10+5);
	}
	if(@"boo" == @"zee") {
		b = @"dho";
	}
	if(2 + 3 == 5 + 10) {
		a = 10+5;
	}
	return a;
}


/*
@interface Personnage : NSObject
{
    int vie;
    int mana;
}

+ (id) init;
- (int) vie;
- (int) mana;
- (void) setVie:(int) uneVie;
- (void) setMana:(int) unMana;

@end
*/

/*
#import "Voiture.h"

@implementation Voiture
int b; BOOL c;

+ (id) init : (int) d : (BOOL) e {
   int a;a=0;
}
+ (int) init2 {
   int a;a=0;
}
@end
*/

/*
#import "BankAccount.h"

static int openAccounts = 0;

@implementation BankAccount

+(BankAccount *) newAlloc
{
        openAccounts++;

        return [BankAccount alloc];
}

+(int) totalOpen
{

        return openAccounts;
}
@end
*/
