# Random
* nextInt()​​ gives you an integer between 0 and 232 (exclusive)
* nextInt(n)​​ gives you an integer between 0 and n (exclusive)
* nextDouble()​​ gives you a double between 0.0 and 1.0
```java
Random r = ​new​ Random(); 
r.nextInt(); 
r.nextInt(​100​); 
r.nextDouble();
```
Set random seed
```java
Date d = ​new​ Date();
Random r = ​new​ Random(d.getTime());
```

## layouts
replace the Constraint layout with ```​LinearLayout​​.``` as it is linear

There are two possible orientations: ```horizontal```, ```vertical```.

# Widget
## TextView Widget
The ​id​​ attribute ​​enables you to give a unique ID to each widget in the XML layout file. This allows you to access the widget through the java code.

The ​text​​ attribute​​ specifies the text that the widget should contain.
```xml
<​TextView
    android:id=​"@+id/myTextView" 
    android:layout_width=​"wrap_content"
    android:layout_height=​"wrap_content"
    android:layout_gravity=​"center" 
    android:gravity=​"end" android:text=​"second"​/>
```

## Button Widget
```xml
<​Button
    android:id=​"@+id/myButton" 
    android:layout_width=​"match_parent"
    android:layout_height=​"wrap_content" 
    android:text=​"Click Me"​/>
```

## Alignment for Widget
Note the difference between the two:
* To align a widget within a layout, use the ​layout_gravity​​ attribute
* To align the contents of a widget within itself, use the ​gravity​​ attribute


## Oncreate concept
onCreate is called when the Activity is first launched;

This method is part of the methods in the ​Android activity life cycle​​;

You write code in ​onCreate​​ to implement what you want the user to see when the activity is launched.;
```java
@Override
protected​ ​void​ ​onCreate​(Bundle savedInstanceState) { ​
    super​.onCreate(savedInstanceState); 
    setContentView(R.layout.activity_main);
}
```

## Resource ID
### Widget ID
If your widget has the following attribute
android:id =”@+id/myWidget” then it can be accessed by ​R.id.myWidget​​.

In Java.
```java
TextView textView = findViewById(R.id.myTextView);
```
change the properties of widget in java
```java
textView.setText(​"My New String"​)
```

### Images in drawables
If you have an image stored in the drawable folder named ​pikachu.png​​, then it can be accessed by ​R.drawable.pikachu​​. (image file names must be lowercase)

## R class
When the app is compiled, a ​R class​​ is generated that contains IDs to the resources in the res​​ folder.
Since ​```activity_main.xml​​``` is stored in the layout folder, its R class reference is ```R.layout.activity_main​​.```

```R.layout.activity_main``` ​​is passed to the ​setContentView​​ method to ​inflate the layout​​. Andriod Studio reads the xml file and instantiates the result.

R class can be found at ```app/build/generated/source/r/debug/<your.package.name>```




## Bind a button to a variable
1. first method
```java
public​ ​class​ ​MainActivity​ ​extends​ ​AppCompatActivity​ { 
    Button button;
​    @Override
​    protected​ ​void​ ​onCreate​(Bundle savedInstanceState) {
​        super​.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.myButton1);
        button.setOnClickListener( ​new​ ClickMe()); 
    }
​    //*** this is an inner class ***
​    class​ ​ClickMe​ ​implements​ ​View​.​OnClickListener​{
​       @Override
​       public​ ​void​ ​onClick​(View v) {
        // code here
        } 
    }
}
```
1. Anonymous class(Recommend)
```java
public​ ​class​ ​MainActivity​ ​extends​ ​AppCompatActivity​ { 
    Button button;
​    @Override
​    protected​ ​void​ ​onCreate​(Bundle savedInstanceState) {
​        super​.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.myButton1);
        button.setOnClickListener(​new​ View.OnClickListener() { ​@Override
​            public​ ​void​ ​onClick​(View v) {
​                //code goes here }
            }
        }); 
    }
}
```
## final code
```java
public class MainActivity extends AppCompatActivity {
    ArrayList<Integer> images;
    Button charaButton;
    ImageView charaImage;
    TextView charaTextView; // TODO: add this in
    Button myButton;
    int count = 0 ;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super .onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO 1.3 Instantiate an ArrayList object
        images = new ArrayList<>();
        //TODO 1.4 Add the image IDs to the ArrayList
        images.add(R.drawable.bartsimpson);
        images.add(R.drawable.nickwilde);
        images.add(R.drawable.ashketchum);
        images.add(R.drawable.doraemon);
        images.add(R.drawable.judyhopps);
        images.add(R.drawable.nickwilde);
        images.add(R.drawable.pikachu);
        //TODO 1.5 Get references to charaButton and charaImage
        //using findViewById
        charaButton = findViewById(R.id.charaButton);
        charaImage = findViewById(R.id.charaImage);
        charaTextView = findViewById(R.id.testViewRandomImages);
        myButton = findViewById(R.id.myButton);

        //TODO 1.6 For charaButton, invoke the
        //setOnClickListenerMethod

        //TODO 1.7 Create an anonymous class which implements
        //View.OnClickListener

        //TODO 1.8 Write code to randomly select an image ID from
        //the ArrayList and display it in the ImageView
        charaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idx = count % images.size();
                count += 1;
                int id = images.get(idx);
                charaImage.setImageResource(id);
            }
        });

        //TODO 1.9 [On your own] Create another Button to always
        //display the first image
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                charaImage.setImageResource(R.drawable.judyhopps);
            }
        });
    }
}
```
