@interface Personnage : NSObject
{
    int vie;
    int mana;
}

- (id) init;
- (int) vie;
- (int) mana;
- (void) setVie:(int) uneVie;
- (void) setMana:(int) unMana;

@end

/*#import "Voiture.h"

@implementation Voiture

- (id) init {
   int a;a=0;
}
- (id) init2 {
   int a;a=0;

@end*/
