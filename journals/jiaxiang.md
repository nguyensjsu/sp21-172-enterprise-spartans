Payment Page Output with validation form checking
![1](sp21-172-enterprise-spartans/images/1.png)
![1](sp21-172-enterprise-spartans/images/2.png)
<br><br/>
It is succesfully process the payment.
![1](sp21-172-enterprise-spartans/mages/9.png)
<br><br/>
This is the detail of the payment transation on CyberSource.
![1](sp21-172-enterprise-spartans/images/10.png)
![1](sp21-172-enterprise-spartans/images/11.png)
<br><br/>
This payment api is finished and ready to be applied

Code to control the validation form.
        Pattern pattern = Pattern.compile("\\d{3}");
        Matcher matcher = pattern.matcher(command.getcvv());
        Pattern pattern1 = Pattern.compile("\\d{5}");
        Matcher matcher1 = pattern1.matcher(command.getZip());
        Pattern pattern2 = Pattern.compile("\\d{4}-\\d{4}-\\d{4}-\\d{4}");
        Matcher matcher2 = pattern2.matcher(command.getcardnumber());
        Pattern pattern3 = Pattern.compile("[(]\\d{3}[)] \\d{3}-\\d{4}");
        Matcher matcher3 = pattern3.matcher(command.getphonenumber());
        Pattern pattern4 = Pattern.compile("\\d{4}");
        Matcher matcher4= pattern4.matcher(command.getexpyear());
        
        /* Render View */
        model.addAttribute( "message", "Thank you for your payment" ) ;

        if (!matcher.matches()) {
            model.addAttribute( "message", "Validation Errors, Please Resubmit." ) ;
            System.out.println("The CVV number is invalid");
            return "creditcards";
        }
        if (!matcher1.matches()) {
            model.addAttribute( "message", "Validation Errors, Please Resubmit." ) ;
            System.out.println("The Zip code is invalid");
            return "creditcards";
        }
        if (!matcher2.matches()) {
            model.addAttribute( "message", "Validation Errors, Please Resubmit." ) ;
            System.out.println("The Card Number is invalid");
            return "creditcards";
        }
        if (!matcher3.matches()) {
            model.addAttribute( "message", "Validation Errors, Please Resubmit." ) ;
            System.out.println("The Phone Number is invalid");
            return "creditcards";
        }
        if (!matcher4.matches()) {
            model.addAttribute( "message", "Validation Errors, Please Resubmit." ) ;
            System.out.println("The Expiration Year is invalid");
            return "creditcards";
        }
