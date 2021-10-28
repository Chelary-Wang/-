def main():
    while 1:
        age = int(input("Enter your age: "))
        cri = (input("Do you have a criminal record (y/n): "))
        if cri == "y" or cri == "n":
            if 18 <= age <= 65 and cri == "n":
                print("You are required to do jury service.")
            else:
                print("You are not required to do jury service.")
            return
        else:
            print("Incorrect input.")


if __name__ == "__main__":
    main()
