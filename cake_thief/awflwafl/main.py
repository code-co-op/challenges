# This is the "Newbie Club" solution that was developed in a TDD approach, without any refactoring

from collections import namedtuple

# ------------------------------

# Taste Harness
def taste(taste_case):
    """Taste harness."""
    result = "PASS" if (taste_case() is True) else "FAIL"

    print(result, "-", taste_case.__doc__ or "No description...")

# ------------------------------
# Utilities

Cake = namedtuple('Cake', ['weight', 'value'])

def has_no_better_cake(cake, smaller_cakes):
    for smaller_cake in smaller_cakes:
        # calculate
        quantity = cake.weight // smaller_cake.weight
        smaller_cake_value = smaller_cake.value * quantity

        if smaller_cake_value >= cake.value:
            return False

    return True

def throw_out_crappy_cakes(cakes):
    """Throw out cakes that ain't worth their weight"""

    good_cakes = []

    for index, cake in enumerate(cakes):
        if has_no_better_cake(cake, cakes[index+1:]):
            good_cakes.append(cake)

    return good_cakes

# ------------------------------
# Function Under Taste

def max_duffel_bag_value(cakes, capacity):
    """Function under taste."""
    value = 0

    good_cakes = throw_out_crappy_cakes(cakes)

    for cake in good_cakes:
        if capacity >= cake.weight:
            # calculate
            quantity    = capacity // cake.weight
            cake_weight = cake.weight * quantity
            cake_value  = cake.value * quantity

            # update
            value       += cake_value
            capacity    -= cake_weight

    return value



# ------------------------------
# Utility Taste Cases

def utility_case_1():
    """When there are no cakes, there is nothing to throw out"""
    cakes = []

    return throw_out_crappy_cakes(cakes) == []


def utility_case_2():
    """When a cake is crappy, it is thrown out"""
    cakes = [Cake(2, 1), Cake(1, 2)]

    return throw_out_crappy_cakes(cakes) == [Cake(1, 2)]

taste(utility_case_1)
taste(utility_case_2)

# ------------------------------
# Taste Cases

def case_1():
    """Zero capacity taste"""
    cakes       = [Cake(1, 1)]
    capacity    = 0

    return max_duffel_bag_value(cakes, capacity) == 0


def case_2():
    """Zero cakes taste"""
    cakes       = []
    capacity    = 1

    return max_duffel_bag_value(cakes, capacity) == 0


def case_3():
    """One cake with exact capacity"""
    cakes       = [Cake(1, 2)]
    capacity    = 1

    return max_duffel_bag_value(cakes, capacity) == 2


def case_4():
    """Can take two of the same cake, and use all capacity"""
    cakes       = [Cake(1, 2)]
    capacity    = 2

    return max_duffel_bag_value(cakes, capacity) == 4


def case_5():
    """Can take two of the same cake, but not use all capacity"""
    cakes       = [Cake(2, 2)]
    capacity    = 5

    return max_duffel_bag_value(cakes, capacity) == 4

def case_6():
    """Can take different types of cake, and use all capacity"""
    cakes       = [Cake(2, 3), Cake(1, 2)]
    capacity    = 3

    return max_duffel_bag_value(cakes, capacity) == 5


def case_6():
    """Can take different types of cake, and the first are the best, but only takes the best"""
    cakes       = [Cake(3, 3), Cake(2, 2)]
    capacity    = 6

    return max_duffel_bag_value(cakes, capacity) == 6


def case_7():
    """Can take different types of cake, and the last are the best, but only takes the best"""
    cakes       = [Cake(2, 1), Cake(1, 2)]
    capacity    = 2

    return max_duffel_bag_value(cakes, capacity) == 4

def case_8():
    """Can take different types of cake, but doesn't need all types to fill capcacity"""
    cakes       = [Cake(3, 3), Cake(2, 2), Cake(1, 1)]
    capacity    = 4

    return max_duffel_bag_value(cakes, capacity) == 4


def final_judgement():
    """InterviewCake provided taste"""
    cakes       = [Cake(7, 160), Cake(3, 90), Cake(2, 15)]
    capacity    = 20

    return max_duffel_bag_value(cakes, capacity) == 555

print()
taste(case_1)
taste(case_2)
taste(case_3)
taste(case_4)
taste(case_5)
taste(case_6)
taste(case_7)
taste(case_8)

print()
taste(final_judgement)

# ------------------------------
