
# scrmTest

In order to be able to run this test Gradle and ChromeDriver are needed.

I recommend [Brew](https://brew.sh/) to install both dependencies:
* [Gradle](https://gradle.org/install/)
* Chromedriver: `brew install chromedriver`
  * Then to Chromedriver should be started:  `$ chromedriver`

To execute the test just run: `gradle test`

----
This test automation example uses Gradle, TestNG and the page object pattern.
* Gradle provides an easy way to solve dependencies from the testing framework.
* TestNG is a powerful testing framework that will not only gives the property to launch tests, also will provide solutions like to modify the tests listeners, test groups, etc..
* With the page object pattern every different page from the app will be represented by a single class. Un such way this framework will be easily to increase and maintain.

Wait for page loaded:
In this example I am using the wait for page loaded in each page object constructor, so every time a new page object is needed, the framework will wait for the most relevant element is present, assuring that the test can continue. This also allows avoid explicit waits in the test class.

Test definition:
This test just adds an item to the cart, without login and the item is a random one but by the keywords 'pantalla'.
* Access Amazon.es
* Search for the item 'Pantalla'
* Access the first item from the search results
* Add the item to the cart
* Access the cart and ensure that the element was added to the cart and the user can proceed with the payment.