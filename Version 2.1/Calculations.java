class Calculations
{
   double bWeightLbs;
   double bWeightKg;
   double bodyFatPrcnt;
   double fatMass; 
   double fatFreeMass = 0;
   double metabolicRate = 0;
   double targetFatMass;
   double targetFatFreeMassDecimal;
   double targetTotalMassKg = 0;
   double targetTotalMassLbs;
   double targetCalorieBurn;
   double activityFactor;
   double rmrActivity;
   double weightTime;
   double expendWeights;
   double rmrWeights;
   double cardioTime;
   double expendCardio;
   double rmrCardio;
   double thermicEffect;
   double finalMR;
   double restingMR;
   double adjustedMR;
   final double KGperLB = 2.20462;
   final double CALORIESperLB = (23.0 / 15.0);
 
   
   public double calcKilos(double enteredWeight)
   {
      bWeightLbs = enteredWeight;
      
      // convert to kg
      bWeightKg = (bWeightLbs / KGperLB);
      
      return bWeightKg;
   }
   
   public double calcFFM(double enteredBodyFat)
   {
      bodyFatPrcnt = enteredBodyFat;
      
      // calculate fat mass
      fatMass = bWeightKg * (bodyFatPrcnt/100); 
      
      // calculate fat free mass
      fatFreeMass = bWeightKg - fatMass;
      
      return fatFreeMass;  
   }
   
   public double calcRMR()
   {
      if (fatFreeMass != 0)
      {
         // calculate resting metabolic rate
         metabolicRate = 500 + (22 * fatFreeMass);
         restingMR = metabolicRate;
      }
      
      return metabolicRate;
   }
   
   public double calcActivityFactor(double activityInput)
   {      
      activityFactor = activityInput;  
                    
      // calculate rmrActivity
      metabolicRate *= activityFactor;
                  
      return metabolicRate;
   }
   
   public double calcWeightsExpend(double weightsInput)
   {
      weightTime = weightsInput;
      
      // calculate weights expenditure
      expendWeights = (double)(6 * bWeightKg * weightTime);
            
      // add weights expenditure to totalMR
      metabolicRate += expendWeights;
            
      return metabolicRate;      
   }
   
   public double calcCardioExpend(double cardioInput)
   {
      cardioTime = cardioInput;
      
      // calculate cardio expenditure
      expendCardio = (double)(7 * bWeightKg * cardioTime);
      
     // add cardio expenditure to total caloric need
     metabolicRate += expendCardio;
     
     return metabolicRate;
   }
   
   public double calcTEF1()
   {
      thermicEffect = restingMR * 0.05;
      
      finalMR = metabolicRate + thermicEffect;
      
      return finalMR;
   }
   
   public double calcTEF2()
   {
      thermicEffect = restingMR * 0.10;
      
      finalMR = metabolicRate + thermicEffect;
      
      return finalMR;
   }
   
   public double calcTEF3()
   {
      thermicEffect = restingMR * 0.15;
      
      finalMR = metabolicRate + thermicEffect;
      
      return finalMR;
   }
   
   public double calcAMR()
   {
      // calculate AMR
      adjustedMR = restingMR - 500;
      
      return adjustedMR;
   }
   
   public double calcExercise()
   {
      // calc exercise needed
      targetCalorieBurn = bWeightLbs * CALORIESperLB;
      
      return targetCalorieBurn;
   }
   
   public double calcWeightLoss(double targetFatInput)
   {
      targetFatMass = targetFatInput;
      
      targetFatFreeMassDecimal = (100 - targetFatMass) / 100;
      
      return targetFatFreeMassDecimal;
   }
   
   public double calcTotalMassKg()
   {
      // calculate total mass kg
      targetTotalMassKg = fatFreeMass / targetFatFreeMassDecimal;
      
      return targetTotalMassKg;
   }
   
   public double calcTotalMassLbs()
   {
      // calc total mass lbs
      targetTotalMassLbs = targetTotalMassKg * KGperLB;
      
      return targetTotalMassLbs;
   }
}