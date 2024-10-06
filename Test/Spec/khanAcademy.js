describe('khan Academy test suite', () => {

    beforeEach(async() => {
        const context = await driver.getContext();
        console.log(context);
    });

    it('launch the application',async () => {

        await driver.pause(5000) //wait for 5 seconds

        // when the application is opened click on dismiss button
        const dismiss = await $('//android.widget.Button');
        await dismiss.click();

        // then click on search icon or button
        const search = await $('~Search tab');
        await search.click();

        // then select and click on computing topic
        const computing = await $('//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.Button[5]');
        await computing.click();

        // then select computer science theory under computing
        const computerScience = await $('~Computer science theory');
        await computerScience.click();

        // then select cryptography under computer science theory
        const cryptography = await $('android=new UiSelector().className("android.view.ViewGroup").instance(6)');
        await cryptography.click();
    });
    it('Navigation & Bookmarks',async () => {

        await driver.pause(5000) //wait for 5 seconds

        // const Signin = await $('//android.widget.TextView[@text="Sign in"]');
        // await Signin.click();

        // const continuewithGoogle = await $('android.widget.TextView');
        // await continuewithGoogle.click();

        // const selectgmail = await $('android= new UiSelector().className("android.widget.LinearLayout").instance(3)');
        // await selectgmail.click();

        // const search = await $('~Search tab');
        // await search.click();

        // bookmark ancient cryptography topic
        await $('android=new UiSelector().className("android.widget.ImageView").instance(0)').click();
        
        // bookmark cryptography challenge 101 topic
        // driver.execute("activity",{properties}) only accessibilty id and class name will work in properties
        await driver.execute("mobile:scroll",{strategy:"class",selector:'android.widget.ImageView'});
        
        await $('android=new UiSelector().className("android.widget.ImageView").instance(2)').click();

        // bookmark modular arithmetic topic
        await driver.execute("mobile:scroll",{strategy:"class",selector:'android.widget.ImageView'})
        await $('android=new UiSelector().className("android.widget.ImageView").instance(10)').click();


    });
    it('Bookmark more topics',async () => {

        await driver.pause(5000) //wait for 5 seconds

        await driver.pressKeyCode(4); // pressing back button
        
        // click on information theory subject
        const infoTheory = await $('android=new UiSelector().className("android.view.ViewGroup").instance(12)');
        await infoTheory.click();

        // then bookmark modern information theory topic
        await $('android=new UiSelector().className("android.widget.ImageView").instance(10)')


    });
    it('Verify Bookmarks',async () => {

        await driver.pause(5000) //wait for 5 seconds

        // Go to all bookmarks page by clicking on All bookmarks icon
        const bookmarksTab = await $('~Bookmarks tab');
        await bookmarksTab.click();

        // Assert or check if the Modern information theory topic is present in bookmarks or not
        const bookMark1 = await $('//android.widget.TextView[@text="Modern information theory"]');
        await expect(bookMark1).toBeExisting();

         // Assert or check if the Modular Arithmetic topic is present in bookmarks or not
         const bookMark2 = await $('//android.widget.TextView[@text="Modular arithmetic"]');
         await expect(bookMark2).toBeExisting();

        // Assert or check if the Cryptography challenge 101 topic is present in bookmarks or not
        const bookMark3 = await $('//android.widget.TextView[@text="Cryptography challenge 101"]');
        await expect(bookMark3).toBeExisting();

         // Assert or check if the Ancient cryptography topic is present in bookmarks or not
         const bookMark4 = await $('//android.widget.TextView[@text="Ancient cryptography"]');
         await expect(bookMark4).toBeExisting();
        
    });
    it('Clear Bookmarks',async () => {

        await driver.pause(5000) //wait for 5 seconds

        // after asserting all the bookmarked topics click on edit in the top right corner
        const editBookmarks = await $('//android.widget.TextView[@text="Edit"]');
        await editBookmarks.click();

        // select modern information theory to delete from bookmarks
        await $('android=new UiSelector().className("android.widget.Button").instance(1)').click();
        
        // select modular Arithmetic to delete from bookmarks
        await $('android=new UiSelector().className("android.widget.Button").instance(2)').click();

        // select cryptography challenge 101 to delete from bookmarks
        await $('android=new UiSelector().className("android.widget.Button").instance(3)').click();

        // select Ancient cryptography to delete from bookmarks
        await $('android=new UiSelector().className("android.widget.Button").instance(4)').click();

        const deleteAll = await $('android=new UiSelector().text("Delete")');
        await deleteAll.click();
        
    });
    it('Explore Additional topics',async () => {

        await driver.pause(5000) //wait for 5 seconds

        const search = await $('~Search tab');
        await search.click();
        await search.click();

        const lifeSkills = await $('//android.widget.TextView[@text="Life skills"]');
        await lifeSkills.click();

        const financialLiteracy = await $('~Financial Literacy');
        await financialLiteracy.click();

        const welcomeToFinLiteracy = await $('android=new UiSelector().className("android.view.ViewGroup").instance(8)');
        await welcomeToFinLiteracy.click();

        const firstTopic = await $('android=new UiSelector().className("android.widget.Button").instance(1)');
        await firstTopic.click();

        
    });
    it('Verify recent lessons',async () => {

        await driver.pause(5000) //wait for 5 seconds

        const Home = await $('~Explore tab');
        await Home.click();

        // check if the recently played lecture is in the recent lessons or not
        const assert = await $('//android.widget.TextView[@text="Intro to Financial Literacy"]');
        await expect(assert).toHaveText("Intro to Financial Literacy");

        
    });
    it('Open notifications',async () => {

        await driver.openNotifications(); // To access the notifications
        
    });
    it('Clear notifications',async () => {

        //await driver.openNotifications(); // To access the notifications
        await $("~Clear all notifications.").click // clear all notifications
    });
    it('Close the application',async () => {

        await driver.pressKeyCode(3);
        
    });
});
