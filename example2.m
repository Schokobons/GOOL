
@implementation test
int a = 0;

+ (BOOL) exemple {
	unType unObjet;
	char b;
	a = [unObjet init];
	[unObjet init : b];
	[unObjet init];
	if(a + 3 == 5 + 10) {
		a = (10+5);
	}
	if(@"boo" == @"zee") {
		b = 'h';
	}
}

@end

/*
#import "exemple.h"
int main(void) {
	float a = pow(2, 3);
	int i = 0;
	while(i < 10)
	{
		i++;
		a = a + 10;
	}
	return 0;
}
*/

/*
int main(void) {
	int a = 10;
	int i;
	for(i = 0; i < 10; i++) {
		a = a + 10;
	}
	return 0;
}
*/

/*
int main(int a) {
	id unObjet = nil;
	char b;
	NSLog(@"Voici une chaine de caractères en Objective-C.");
	--unObjet;
	unObjet = [unObjet init];
	[unObjet init];
	[unObjet init: a s:a :a];
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
