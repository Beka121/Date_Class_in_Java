# Date Management Program

## For Reader

This program allows users to manage dates by adding, updating, comparing, and displaying them. The program ensures valid date input, sorts dates chronologically, and calculates differences between them.

## Features

- **Add Dates**: Users can enter valid dates.
- **Sort Dates**: Automatically sorts dates in ascending order (year, month, day).
- **Compare Dates**: Computes the difference in days between two selected dates.
- **Update Dates**: Modify an existing date.
- **Show All Dates**: Displays stored dates.
- **Check Day of the Week**: Determines which day of the week a date falls on.
- **Validate Input**: Prevents invalid date entries.

## Usage

Run the program and use the following commands:
- `Enter year, month, and day` → Add a new date.
- `show` → Display all stored dates.
- `compare` → Compare two dates and get the difference in days.
- `update` → Modify an existing date.
- `exit` → Exit the program.

### Example

```plaintext
1) Enter year, month, and day
2) Type 'exit' to finish
3) 'compare' to compare two dates
4) 'update' to modify a date
5) 'show' to display all dates

2024 3 31
March 31, 2024
Day of the week: Sunday

Enter year, month, and day:
2023 5 15
May 15, 2023
Day of the week: Monday

compare
Select two dates by index:
1. 31/03/2024
2. 15/05/2023
Difference: 321 days
```

## Data Structures

- `List<Date> dates` → Stores user-entered dates.
- `Scanner sc` → Handles user input.
- `Date` class → Stores and manipulates date-related information.
- `Calendar` → Used to compute the day of the week and date differences.

## Problems & Limitations

1. **No time handling**: This program only manages dates, not time.
2. **No persistence**: Dates are not saved once the program exits.
3. **Limited input validation**: The program assumes proper integer input.

## Requirements

- Java 8 or later.

## Video

Check out this video: [Watch the video](https://youtu.be/9d7itqKcK10?si=18MVX1_zuN9Lvgvh)

<p align="center">
    <a href="https://youtu.be/9d7itqKcK10?si=18MVX1_zuN9Lvgvh">
        <img src="https://img.shields.io/badge/YouTube-090909?style=for-the-badge&logo=youtube&logoColor=FF0000">
    </a>
</p>

## Thank You

If you have any questions or suggestions, feel free to reach out!

<p align="center">
    </a>
    <a href="mailto:bekturemilev@gmail.com">
        <img src="https://img.shields.io/badge/Email-090909?style=for-the-badge&logo=gmail&logoColor=red">
    </a>
    <a href="https://t.me/Kaka_short">
        <img src="https://img.shields.io/badge/Telegram-090909?style=for-the-badge&logo=telegram&logoColor=26A5E4">
    </a>
</p>
