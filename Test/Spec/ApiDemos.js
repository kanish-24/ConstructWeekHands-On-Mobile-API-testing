// if it is hybrid app I am going to use xpath as my only locator or selector
describe('Appium', () => {

    beforeEach(async() => {
        const context = await driver.getContext();
        console.log(context);
    });
    //sync - it means test cases are dependent & async means they are not dependant
    it.only('App',async () => {

        //Anything i want to do with the screen i will use 
        //driver object > ex. is pause and scoll
        //Anything i want to do with elements i will use the locators
 
        // UiAutomator2-driver methods can be accessed by driver object
        await driver.pause(5000); //5 seconds
        const app = await $("~App"); // Accessibility id
        // Any of the locator here in mobile testing we are going to give with $("~<ACID></ACID>")

        await app.click();

        const bar= await $("~Action Bar");
        await expect(bar).toBeExisting();
        // to be existing will assert the element is present or exist
        
    });
    it('ApiTitle',async () => {

        //find element by class Name 
        //API Demos //This is at the first screen
        const title = await $("android.widget.TextView"); // classname
        console.log(await title.gettext());

        // Assertion
        await expect(title).toHaveText("API Demos");

    });
    it('Action Bar',async () => {

        await driver.pause(5000);
        const app = await $("~App");
        await app.click();

        const actionBar = await $("~Action Bar");
        actionBar.click();

        const acMechanics = await $("~Action Bar Mechanics");
        acMechanics.click();
        
    });
    it('Action Bar tabs', async () => {

        await driver.pause(5000);
        const app = await $("~App");
        await app.click();

        const actionBar = await $("~Action Bar");
        actionBar.click();

        const tab = await $("~Action Bar Tabs");
        await tab.click();

        const title=await $("~Add new tab");
        console.log(await title.getText());
        await expect(title).toHaveText("ADD NEW TAB");
        
        
    });
    it('Scroll secure surfaces', async () => {

        await driver.pause(5000);
        const app = await $("~App");
        await app.click();

        // you need to give particular android = locator
        await $('android = new UiSelector().text("Activity")').click();
        // xpath-locator no need to give any symbol
        const sec = await $('//android.widget.TextView[@content-desc="Secure Surfaces"]');
        // driver.execute("activity",{properties}) only accessibilty id and class name will work in properties
        await driver.execute("mobile:scroll",{strategy:"accessibility id",selector:'Secure Surfaces'})
        
        await sec.click();
        const sec1=await $('//android.widget.TextView[@content-desc="Animation"]');

        await driver.execute("mobile:scroll",{strategy:"accessibility id",selector:'Animation'})

        await sec1.click();

    });
    it('ScrolltoTranslucent', async() => {
        await driver.pause(5000);
        const app = await $("~App");
        await app.click();

        await $('android = new UiSelector().text("Activity")').click();

        // Xpath locator-no need to give any symbol 
        const sec = await $('//android.widget.TextView[@content-desc="Translucent"]')
        await driver.execute("mobile:scroll",{strategy:"accessibility id",selector:'Translucent'})
        // driver.execute("activity",{properties}) only accessibilty id and class name will work in properties
        await sec.click();
        
    });
    it('Views', async() => {

       const view = await $('~Views');
       await view.click();

       const auto = await $('~Auto Complete');
       await auto.click();
       
       const screen = await $('~1. Screen Top');
       await screen.click();
       
       // setValue will be use to type inside native app input 
       await $('android=new UiSelector().resourceId("io.appium.android.apis:id/edit")').setValue('India');
       
       await $('android=new UiSelector().resourceId("io.appium.android.apis:id/edit")').click();

       await $('~Give me Focus').click();

    });
    it('verify Text Multiple elements',async () => {

        const expectedList = [
            'API Demos', 'Accessibility', 'Animation', 'App', 'Content',
            'Graphics', 'Media', 'NFC', 'OS', 'Preference', 'Text', 'Views'
        ];

        const actualList = []
        const classList = await $$('android.widget.TextView')
        // To find the elements in a same class we will give $$ 

        for (const element of classList) {
            const textElement = await element.getText();
            actualList.push(textElement);

        }

        console.log(actualList);
        await expect(actualList).toEqual(expectedList);
    });
    it('verify Text Multiple elements in the apps',async () => {

        const app = await $('~App');
        await app.click();

        const expectedList = [
            'API Demos','Action Bar', 'Activity', 'Alarm', "Alert Dialogs",
            "Device Admin", "Fragment", "Launcher Shortcuts",  "Loader",  "Menu",
            "Notification", "Search", "Service", "Text-To-Speech", "Voice Recognition",
        ];

        const actualList = []
        const classList = await $$('android.widget.TextView')
        // To find the elements in a same class we will give $$ 

        for (const element of classList) {
            const textElement = await element.getText();
            actualList.push(textElement);

        }

        console.log(actualList);
        await expect(actualList).toEqual(expectedList);
        
    });
    it('VeriftText - Multiple Elements in the apps',async () => {

        await driver.pause(5000);
        const app=await $("~App");
        await app.click();
  
        const expectedList = ['API Demos' , 'Action Bar', 'Activity', 'Alarm',];
        
        const actualList = [ ]
  
        //TO find the elements in a samne class we will give ( $$ )
        const classList= await $$('android.widget.TextView')
      
        for (let element=0 ; element<=3; element++) {
  
        const textElement = await classList[element].getText();
        actualList.push(textElement);
  
      }
      console.log(actualList);
  
      await expect(actualList).toEqual(expectedList);
        
    });

    it('Notifications', async () => {
        await driver.openNotifications(); // To access the notifications
        
    });
    it('Alerts',async () => {

        await driver.pause(5000); //5 seconds
        const app = await $("~App");
        app.click();

        await $("~Alert Dialogs").click(); // Alert Dialogs
        await $("~OK Cancel dialog with a message").click(); // Ok cancel dialog with a message

        //await driver.acceptAlert(); // ok button
        await driver.dismissAlert(); // cancel button

        //dismissAlert(), acceptAlert()
    });
    it('Alert long msg',async () => {

      await driver.pause(5000);
      const app=await $("~App");
      await app.click();

      await $ ("~Alert Dialogs").click();

      await $ ("~OK Cancel dialog with a long message").click();
      
      await driver.acceptAlert();
        
    });
    it('Alert Ultra Long Msg',async () => {

      await driver.pause(5000);
      const app=await $("~App");
      await app.click();

      await $ ("~Alert Dialogs").click();

      await $ ("~OK Cancel dialog with ultra long message").click();
      
      await driver.dismissAlert();
        
    });
    it('Clear notifications',async () => {

        await driver.openNotifications(); // To access the notifications
        await $("~Clear all notifications.").click // clear all notifications
    });
    it('Navigation',async () => {

        await driver.back(); // this forcefully go back

        // this click on back button of mobile
        await driver.pressKeyCode(4); // Back Button: 4
        
        await driver.pressKeyCode(3);// Home Button: 3
        await driver.pressKeyCode(187);// Apps Button (Recent Apps): 187
        await driver.pressKeyCode(82);// Menu Button: 82
        await driver.pressKeyCode(84);// Search Button: 84
        await driver.pressKeyCode(66);// Enter Button: 66
        await driver.pressKeyCode(24);// Volume Up: 24
        await driver.pressKeyCode(25);// Volume Down: 25
        await driver.pressKeyCode(26);// Power Button: 26

    });
  
    
});