let bottleText b =
  match b with
  | 0 -> "No more bottles"
  | 1 -> "1 bottle"
  | _ -> String.concat " " [(sprintf "%i" b);"bottles"]

let rec bottles b =
  match b with
  | 0 -> printfn "%s of beer on the wall, %s of beer"
         printfn "Go to the store and buy some more, %s bottles of beer on the wall" (bottleText 99)
  | _ -> printfn "%s of beer on the wall, %s of beer" (bottleText b) (bottleText b)
         printfn "Take one down and pass it around, %s of beer on the wall" (bottleText (b-1))
         bottles (b-1)

let x = bottles 99
