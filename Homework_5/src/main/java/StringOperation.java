public class StringOperation{

    public float getLoanRepaymentSum(int loanPercent, int loanAmount, int loanTerm) {
        int percentDivider = 100;
        float loanSumPerDay = ((loanAmount * loanPercent) / percentDivider) / loanTerm;
        return loanSumPerDay * loanTerm;
    }

    public int getCookiesAmount(int sugar, int flour, int eggs, int water, int salt) {
        return ((flour * eggs) + (sugar + salt)) / water;
    }

    public String getHelloPhrase(String name, String position, String gender) {
        String standartPhrase = "Hello, ";
        if (name == "Pavel" & position == "QA" & gender == "man") {
            return standartPhrase + name;
        }
        if (name == "Ulyana") {
            return standartPhrase + ", " + "Teacher";
        }
        return standartPhrase + name + "." + "Who are you?";
    }

    public int getSumWithMinus(int numberA, int numberB) {
        return -(numberA + numberB);
    }

    public void validateEmail(String email){
        if (email.contains(" ")) {
            throw new RuntimeException("This is invalid email");
        }
    }
}

