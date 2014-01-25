/*
int main(int a) {
	int unObjet = 10;
	unObjet = [unObjet init];
	[unObjet init: a];
	[unObjet init: a s:a :a];
	char* b;
	if(a + 3 == 5 + 10) {
		a = (10+5);
	}
	if(@"boo" == @"zee") {
		b = @"dho";
	}
	if(2 + 3 == 5 + 10) {
		unObjet = 10+5;
	}
	return a;
}
*/

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
- (void) setVie:(int) uneVie :(int) unMana;
- (void) setVie:(int) uneVie etMana: (int) mana;

@end
*/


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
