using System;

namespace CakeThief
{
    class Program
    {
        //My name is Didas72
        //Here is my solution to the cake thief challenge.
        //I wrote this in C# and I included a few coments to help those
        //who might not understand the code right away.
        //I hope it helps!

        //I tested the code with cakes having values or weights of 0, as well as a bag wit 0 capacity.
        //It all works and there is the explanation in the comments too. :)

        static readonly CakeType[] cakeTypes = new CakeType[] {
            new CakeType(7, 160),
            new CakeType(3, 90),
            new CakeType(2, 15)
            //values taken from the example on InterviewCake
        };

        static readonly uint capacity = 20;



        static void Main()
        {
            uint maxValue = MaxDuffelBagValue();

            Console.WriteLine("Max value is " + maxValue);
            Console.ReadLine();
        }



        static uint MaxDuffelBagValue()
        {
            //If there is a cake with no weight, just return infinity, since we don't have that, we can just return the max value.
            if (HasZeroWeigthCake()) return uint.MaxValue;

            //If we have no space, we can't carry nothing. :)
            if (capacity == 0) return 0;

            //Then we should order the cakes per value density.
            //Our only limitation is weight, and our goal is value.
            //If we sort the cake types by their value per weigth, we can see which cakes are the best trade!

            //We will store each ValueDensity in an array, which we will later sort.
            ValueDensity[] densities = new ValueDensity[cakeTypes.Length];

            //We now populate the array with the appropriate values.
            for (int i = 0; i < densities.Length; i++)
            {
                densities[i] = new ValueDensity(i, cakeTypes[i].value / (float)cakeTypes[i].weight);
            }

            //We will now sort the cake types in order of value density to start building our max value.
            densities = SortDensities(densities);

            //Now we add the cake of highest density that fits in the bag untill we are out of space.
            //Here are some variables used to keep track of our value, used capacity, best cake that can still fit,
            //as well as the cake type we are currently trying.
            uint usedCapacity = 0;
            uint totalValue = 0;
            int bestFit = 0;
            CakeType typeTrying;

            while (true)
            {
                //First we get the type we want to try to fit in out bag.
                typeTrying = cakeTypes[densities[bestFit].cakeIndex];

                //Then we check if it actually fits.
                if (typeTrying.weight + usedCapacity > capacity)
                {
                    //If it does not fit, we will remember that this type will no longer fit, and we should no longer try it.
                    bestFit++;

                    if (bestFit >= densities.Length)
                    {
                        //If we tried all cake types, we have added all we could,
                        //we can return as there is no more capacity.
                        break;
                    }
                }
                else
                {
                    //If it does fit, add it to the value and to the used capacity.
                    usedCapacity += typeTrying.weight;
                    totalValue += typeTrying.value;
                }
            }

            return totalValue;
        }

        static bool HasZeroWeigthCake()
        {
            //Here we simply check if any cake has a weight of 0,
            //meaning we could carry and infinite amount.
            for (int i = 0; i < cakeTypes.Length; i++)
            {
                if (cakeTypes[i].weight == 0)
                    return true;
            }

            return false;
        }

        static ValueDensity[] SortDensities(ValueDensity[] densities)
        {
            //To sort the densities, we will use a very simple sorting algorithm: Buble Sort.
            //It is NOT the best sorting algorithm, far from that, but it will work for our problem.

            //In a nutshell, we want to loop through our array multiple times until everything is sorted.
            //Every time we loop, we compare two numbers and put the lowest value one last, this way, we take the lowest
            //density element down to the end of our array, which will guarantee it is in place, so we can safely ignore
            //it the next time we loop.

            //Here we will keep track of how many elements we actually have to sort.
            int count = densities.Length;

            //And here we just store the element we want to swap places.
            ValueDensity tmp;

            while (count > 1)
            {
                for (int i = 1; i < count; i++)
                {
                    //We want the highest value at the first element of the array,
                    //so we put the lowest value one at the bottom.
                    if (densities[i - 1].valueDensity < densities[i].valueDensity)
                    {
                        tmp = densities[i];
                        densities[i] = densities[i - 1];
                        densities[i - 1] = tmp;
                    }
                }

                //We decrement the number of values we have to check.
                count--;
            }

            //And once it is sorted we can return the array.
            return densities;
        }
    }



    //Here are some structs to organize data in a cleaner way.
    readonly struct CakeType
    {
        public readonly uint weight;
        public readonly uint value;

        public CakeType(uint weight, uint value)
        {
            this.weight = weight;
            this.value = value;
        }
    }

    readonly struct ValueDensity
    {
        public readonly int cakeIndex;
        public readonly float valueDensity;

        public ValueDensity(int cakeIndex, float valueDensity)
        {
            this.cakeIndex = cakeIndex;
            this.valueDensity = valueDensity;
        }
    }
}
