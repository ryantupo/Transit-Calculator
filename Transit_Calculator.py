
import math
class TransitCalculator:


    def __init__(self, days, rides):
        self.days = days
        self.rides = rides
        self.final_fairs = []
        self.nyc = ["Pay-per-ride (single ride)", "7-day Unlimited Rides", "30-day Unlimited Rides"]
        self.nyc_fairs = [2.75, 33.00, 127.00]
    


    def unil_30_pri(self):
        return((math.ceil(self.days % 30) * 127) / self.rides)

    def unil_7_pri(self):
        return((math.ceil(self.days % 7) * 33) / self.rides)

    def pay_per_ride(self):
        return(2.75 * self.rides)

    def get_ride_prices(self):
        self.final_fairs.extend([self.pay_per_ride(),self.unil_7_pri(), self.unil_30_pri()])
        return self.final_fairs

    def get_Best_Fair(self):
        self.get_ride_prices()

        lowest = self.final_fairs[0]
        lowest_index = 0

        for i in range(len(self.final_fairs)-1):
            if self.final_fairs[i] < lowest:
                lowest = self.final_fairs[i]
            lowest_index +=1
        
        lowest_rate = self.nyc[lowest_index]

        return f"you should get the {lowest_rate} option at ${lowest} per ride"

            




Nyc = TransitCalculator(2, 4)
print(Nyc.get_Best_Fair())