package poker;

import java.util.*;

@SuppressWarnings({ "serial" })
public class Range extends ArrayList<Hand> {
	
	public static final String PUSH_RANKING= "AA KK QQ JJ AKs TT AKo AQs 99 AQo AJs 88 AJo ATs 77 ATo 66 A9s 55 KQs A8s A9o 44 KJs A7s KQo 33 A8o A5s A6s KTs 22 A4s QJs A3s KJo A7o A2s QTs JTs K9s A5o A6o KTo T9s J9s Q9s A4o QJo A3o 98s K8s T8s A2o K7s QTo JTo 87s K6s J8s Q8s 97s 76s K5s K9o T7s 86s 65s K4s T9o J7s Q6s Q7s 96s K3s J9o 54s Q9o 75s Q5s K2s T6s 98o 85s J6s Q4s K8o 64s J5s T8o Q3s 95s K7o 87o 53s J4s J8o K6o Q2s 74s Q8o T5s 97o 76o J3s T4s 43s K5o 84s 63s J2s T7o T3s 86o 65o 94s K4o 52s T2s 93s J7o 73s Q6o 96o Q7o 92s K3o 54o 42s 75o 62s 83s Q5o T6o 82s K2o 32s 85o J6o 64o Q4o 72s J5o 95o Q3o 53o J4o 74o Q2o T5o J3o T4o 43o 84o 63o J2o T3o 94o 52o T2o 93o 73o 92o 42o 62o 83o 82o 32o 72o";
	public static final String CALL_RANKING= "AA KK QQ JJ TT AKs 99 AKo AQs AJs AQo 88 ATs AJo ATo 77 A9s KQs A8s 66 A9o KJs A7s KQo KTs A8o 55 A6s KJo A5s A7o QJs A4s KTo K9s 44 A3s QTs A2s A6o A5o QJo K8s 33 A4o K9o JTs K7s A3o Q9s QTo A2o K6s 22 K5s K8o J9s Q8s JTo K4s K7o Q9o T9s K3s Q7s J8s K2s K6o Q6s T8s K5o J9o Q8o Q5s J7s 98s K4o Q4s T9o Q3s K3o T7s J8o Q7o Q2s 87s 97s J6s K2o Q6o J5s T6s T8o J4s 76s Q5o 86s 96s 98o J7o J3s 65s Q4o J2s 75s T5s 54s T7o Q3o 85s T4s 95s 87o 97o J6o Q2o T3s 64s J5o 74s T2s 53s T6o 84s 76o 94s J4o 86o 96o 43s 93s 63s J3o 92s 65o 73s 52s J2o 83s 75o T5o 54o 82s 85o 42s 95o T4o 62s 32s 64o T3o 72s 74o 53o T2o 84o 94o 43o 93o 63o 92o 73o 52o 83o 82o 42o 62o 32o 72o";
	public static final String LOWE_RANKING= "AA KK QQ JJ AKs AKo TT AQs AQo 99 88 AJs 77 AJo ATs 66 ATo 55 KQs 44 A9s 33 KJs QJs JTs KTs 22 KQo QTs A8s A9o T9s A7s A5s J9s K9s Q9s T8s 98s A6s A4s A3s A2s J8s 87s JTo QJo KJo Q8s K8s 76s 97s T7s 86s J7s QTo K7s Q7s K6s A8o KTo 65s 96s T9o Q6s T6s J6s K5s A7o K4s 75s A5o J9o T8o A6o 98o Q5s K3s Q9o A4o 54s 64s 85s 87o J8o K9o A3o A2o J5s Q4s K2s K8o Q3s 95s K7o 53s J4s K6o Q2s 74s Q8o T5s 97o 76o J3s T4s 43s K5o 84s 63s J2s T7o T3s 86o 65o 94s K4o 52s T2s 93s J7o 73s Q6o 96o Q7o 92s K3o 54o 42s 75o 62s 83s Q5o T6o 82s K2o 32s 85o J6o 64o Q4o 72s J5o 95o Q3o 53o J4o 74o Q2o T5o J3o T4o 43o 84o 63o J2o T3o 94o 52o T2o 93o 73o 92o 42o 62o 83o 82o 32o 72o";
	public static final String[] RP_SPLIT = PUSH_RANKING.split("\\s");
	public static final String[] RC_SPLIT = CALL_RANKING.split("\\s");
	public static final String[] RL_SPLIT = LOWE_RANKING.split("\\s");
	private static String[] RC_COMBOS = "Ac Ad, Ac Ah, Ac As, Ad Ah, Ad As, Ah As, Kc Kd, Kc Kh, Kc Ks, Kd Kh, Kd Ks, Kh Ks, Qc Qd, Qc Qh, Qc Qs, Qd Qh, Qd Qs, Qh Qs, Jc Jd, Jc Jh, Jc Js, Jd Jh, Jd Js, Jh Js, Tc Td, Tc Th, Tc Ts, Td Th, Td Ts, Th Ts, Ac Kc, Ad Kd, Ah Kh, As Ks, 9c 9d, 9c 9h, 9c 9s, 9d 9h, 9d 9s, 9h 9s, Ac Kd, Ac Kh, Ac Ks, Ad Kc, Ad Kh, Ad Ks, Ah Kc, Ah Kd, Ah Ks, As Kc, As Kd, As Kh, Ac Qc, Ad Qd, Ah Qh, As Qs, Ac Jc, Ad Jd, Ah Jh, As Js, Ac Qd, Ac Qh, Ac Qs, Ad Qc, Ad Qh, Ad Qs, Ah Qc, Ah Qd, Ah Qs, As Qc, As Qd, As Qh, 8c 8d, 8c 8h, 8c 8s, 8d 8h, 8d 8s, 8h 8s, Ac Tc, Ad Td, Ah Th, As Ts, Ac Jd, Ac Jh, Ac Js, Ad Jc, Ad Jh, Ad Js, Ah Jc, Ah Jd, Ah Js, As Jc, As Jd, As Jh, Ac Td, Ac Th, Ac Ts, Ad Tc, Ad Th, Ad Ts, Ah Tc, Ah Td, Ah Ts, As Tc, As Td, As Th, 7c 7d, 7c 7h, 7c 7s, 7d 7h, 7d 7s, 7h 7s, Ac 9c, Ad 9d, Ah 9h, As 9s, Kc Qc, Kd Qd, Kh Qh, Ks Qs, Ac 8c, Ad 8d, Ah 8h, As 8s, 6c 6d, 6c 6h, 6c 6s, 6d 6h, 6d 6s, 6h 6s, Ac 9d, Ac 9h, Ac 9s, Ad 9c, Ad 9h, Ad 9s, Ah 9c, Ah 9d, Ah 9s, As 9c, As 9d, As 9h, Kc Jc, Kd Jd, Kh Jh, Ks Js, Ac 7c, Ad 7d, Ah 7h, As 7s, Kc Qd, Kc Qh, Kc Qs, Kd Qc, Kd Qh, Kd Qs, Kh Qc, Kh Qd, Kh Qs, Ks Qc, Ks Qd, Ks Qh, Kc Tc, Kd Td, Kh Th, Ks Ts, Ac 8d, Ac 8h, Ac 8s, Ad 8c, Ad 8h, Ad 8s, Ah 8c, Ah 8d, Ah 8s, As 8c, As 8d, As 8h, 5c 5d, 5c 5h, 5c 5s, 5d 5h, 5d 5s, 5h 5s, Ac 6c, Ad 6d, Ah 6h, As 6s, Kc Jd, Kc Jh, Kc Js, Kd Jc, Kd Jh, Kd Js, Kh Jc, Kh Jd, Kh Js, Ks Jc, Ks Jd, Ks Jh, Ac 5c, Ad 5d, Ah 5h, As 5s, Ac 7d, Ac 7h, Ac 7s, Ad 7c, Ad 7h, Ad 7s, Ah 7c, Ah 7d, Ah 7s, As 7c, As 7d, As 7h, Qc Jc, Qd Jd, Qh Jh, Qs Js, Ac 4c, Ad 4d, Ah 4h, As 4s, Kc Td, Kc Th, Kc Ts, Kd Tc, Kd Th, Kd Ts, Kh Tc, Kh Td, Kh Ts, Ks Tc, Ks Td, Ks Th, Kc 9c, Kd 9d, Kh 9h, Ks 9s, 4c 4d, 4c 4h, 4c 4s, 4d 4h, 4d 4s, 4h 4s, Ac 3c, Ad 3d, Ah 3h, As 3s, Qc Tc, Qd Td, Qh Th, Qs Ts, Ac 2c, Ad 2d, Ah 2h, As 2s, Ac 6d, Ac 6h, Ac 6s, Ad 6c, Ad 6h, Ad 6s, Ah 6c, Ah 6d, Ah 6s, As 6c, As 6d, As 6h, Ac 5d, Ac 5h, Ac 5s, Ad 5c, Ad 5h, Ad 5s, Ah 5c, Ah 5d, Ah 5s, As 5c, As 5d, As 5h, Qc Jd, Qc Jh, Qc Js, Qd Jc, Qd Jh, Qd Js, Qh Jc, Qh Jd, Qh Js, Qs Jc, Qs Jd, Qs Jh, Kc 8c, Kd 8d, Kh 8h, Ks 8s, 3c 3d, 3c 3h, 3c 3s, 3d 3h, 3d 3s, 3h 3s, Ac 4d, Ac 4h, Ac 4s, Ad 4c, Ad 4h, Ad 4s, Ah 4c, Ah 4d, Ah 4s, As 4c, As 4d, As 4h, Kc 9d, Kc 9h, Kc 9s, Kd 9c, Kd 9h, Kd 9s, Kh 9c, Kh 9d, Kh 9s, Ks 9c, Ks 9d, Ks 9h, Jc Tc, Jd Td, Jh Th, Js Ts, Kc 7c, Kd 7d, Kh 7h, Ks 7s, Ac 3d, Ac 3h, Ac 3s, Ad 3c, Ad 3h, Ad 3s, Ah 3c, Ah 3d, Ah 3s, As 3c, As 3d, As 3h, Qc 9c, Qd 9d, Qh 9h, Qs 9s, Qc Td, Qc Th, Qc Ts, Qd Tc, Qd Th, Qd Ts, Qh Tc, Qh Td, Qh Ts, Qs Tc, Qs Td, Qs Th, Ac 2d, Ac 2h, Ac 2s, Ad 2c, Ad 2h, Ad 2s, Ah 2c, Ah 2d, Ah 2s, As 2c, As 2d, As 2h, Kc 6c, Kd 6d, Kh 6h, Ks 6s, 2c 2d, 2c 2h, 2c 2s, 2d 2h, 2d 2s, 2h 2s, Kc 5c, Kd 5d, Kh 5h, Ks 5s, Kc 8d, Kc 8h, Kc 8s, Kd 8c, Kd 8h, Kd 8s, Kh 8c, Kh 8d, Kh 8s, Ks 8c, Ks 8d, Ks 8h, Jc 9c, Jd 9d, Jh 9h, Js 9s, Qc 8c, Qd 8d, Qh 8h, Qs 8s, Jc Td, Jc Th, Jc Ts, Jd Tc, Jd Th, Jd Ts, Jh Tc, Jh Td, Jh Ts, Js Tc, Js Td, Js Th, Kc 4c, Kd 4d, Kh 4h, Ks 4s, Kc 7d, Kc 7h, Kc 7s, Kd 7c, Kd 7h, Kd 7s, Kh 7c, Kh 7d, Kh 7s, Ks 7c, Ks 7d, Ks 7h, Qc 9d, Qc 9h, Qc 9s, Qd 9c, Qd 9h, Qd 9s, Qh 9c, Qh 9d, Qh 9s, Qs 9c, Qs 9d, Qs 9h, Tc 9c, Td 9d, Th 9h, Ts 9s, Kc 3c, Kd 3d, Kh 3h, Ks 3s, Qc 7c, Qd 7d, Qh 7h, Qs 7s, Jc 8c, Jd 8d, Jh 8h, Js 8s, Kc 2c, Kd 2d, Kh 2h, Ks 2s, Kc 6d, Kc 6h, Kc 6s, Kd 6c, Kd 6h, Kd 6s, Kh 6c, Kh 6d, Kh 6s, Ks 6c, Ks 6d, Ks 6h, Qc 6c, Qd 6d, Qh 6h, Qs 6s, Tc 8c, Td 8d, Th 8h, Ts 8s, Kc 5d, Kc 5h, Kc 5s, Kd 5c, Kd 5h, Kd 5s, Kh 5c, Kh 5d, Kh 5s, Ks 5c, Ks 5d, Ks 5h, Jc 9d, Jc 9h, Jc 9s, Jd 9c, Jd 9h, Jd 9s, Jh 9c, Jh 9d, Jh 9s, Js 9c, Js 9d, Js 9h, Qc 8d, Qc 8h, Qc 8s, Qd 8c, Qd 8h, Qd 8s, Qh 8c, Qh 8d, Qh 8s, Qs 8c, Qs 8d, Qs 8h, Qc 5c, Qd 5d, Qh 5h, Qs 5s, Jc 7c, Jd 7d, Jh 7h, Js 7s, 9c 8c, 9d 8d, 9h 8h, 9s 8s, Kc 4d, Kc 4h, Kc 4s, Kd 4c, Kd 4h, Kd 4s, Kh 4c, Kh 4d, Kh 4s, Ks 4c, Ks 4d, Ks 4h, Qc 4c, Qd 4d, Qh 4h, Qs 4s, Tc 9d, Tc 9h, Tc 9s, Td 9c, Td 9h, Td 9s, Th 9c, Th 9d, Th 9s, Ts 9c, Ts 9d, Ts 9h, Qc 3c, Qd 3d, Qh 3h, Qs 3s, Kc 3d, Kc 3h, Kc 3s, Kd 3c, Kd 3h, Kd 3s, Kh 3c, Kh 3d, Kh 3s, Ks 3c, Ks 3d, Ks 3h, Tc 7c, Td 7d, Th 7h, Ts 7s, Jc 8d, Jc 8h, Jc 8s, Jd 8c, Jd 8h, Jd 8s, Jh 8c, Jh 8d, Jh 8s, Js 8c, Js 8d, Js 8h, Qc 7d, Qc 7h, Qc 7s, Qd 7c, Qd 7h, Qd 7s, Qh 7c, Qh 7d, Qh 7s, Qs 7c, Qs 7d, Qs 7h, Qc 2c, Qd 2d, Qh 2h, Qs 2s, 8c 7c, 8d 7d, 8h 7h, 8s 7s, 9c 7c, 9d 7d, 9h 7h, 9s 7s, Jc 6c, Jd 6d, Jh 6h, Js 6s, Kc 2d, Kc 2h, Kc 2s, Kd 2c, Kd 2h, Kd 2s, Kh 2c, Kh 2d, Kh 2s, Ks 2c, Ks 2d, Ks 2h, Qc 6d, Qc 6h, Qc 6s, Qd 6c, Qd 6h, Qd 6s, Qh 6c, Qh 6d, Qh 6s, Qs 6c, Qs 6d, Qs 6h, Jc 5c, Jd 5d, Jh 5h, Js 5s, Tc 6c, Td 6d, Th 6h, Ts 6s, Tc 8d, Tc 8h, Tc 8s, Td 8c, Td 8h, Td 8s, Th 8c, Th 8d, Th 8s, Ts 8c, Ts 8d, Ts 8h, Jc 4c, Jd 4d, Jh 4h, Js 4s, 7c 6c, 7d 6d, 7h 6h, 7s 6s, Qc 5d, Qc 5h, Qc 5s, Qd 5c, Qd 5h, Qd 5s, Qh 5c, Qh 5d, Qh 5s, Qs 5c, Qs 5d, Qs 5h, 8c 6c, 8d 6d, 8h 6h, 8s 6s, 9c 6c, 9d 6d, 9h 6h, 9s 6s, 9c 8d, 9c 8h, 9c 8s, 9d 8c, 9d 8h, 9d 8s, 9h 8c, 9h 8d, 9h 8s, 9s 8c, 9s 8d, 9s 8h, Jc 7d, Jc 7h, Jc 7s, Jd 7c, Jd 7h, Jd 7s, Jh 7c, Jh 7d, Jh 7s, Js 7c, Js 7d, Js 7h, Jc 3c, Jd 3d, Jh 3h, Js 3s, 6c 5c, 6d 5d, 6h 5h, 6s 5s, Qc 4d, Qc 4h, Qc 4s, Qd 4c, Qd 4h, Qd 4s, Qh 4c, Qh 4d, Qh 4s, Qs 4c, Qs 4d, Qs 4h, Jc 2c, Jd 2d, Jh 2h, Js 2s, 7c 5c, 7d 5d, 7h 5h, 7s 5s, Tc 5c, Td 5d, Th 5h, Ts 5s, 5c 4c, 5d 4d, 5h 4h, 5s 4s, Tc 7d, Tc 7h, Tc 7s, Td 7c, Td 7h, Td 7s, Th 7c, Th 7d, Th 7s, Ts 7c, Ts 7d, Ts 7h, Qc 3d, Qc 3h, Qc 3s, Qd 3c, Qd 3h, Qd 3s, Qh 3c, Qh 3d, Qh 3s, Qs 3c, Qs 3d, Qs 3h, 8c 5c, 8d 5d, 8h 5h, 8s 5s, Tc 4c, Td 4d, Th 4h, Ts 4s, 9c 5c, 9d 5d, 9h 5h, 9s 5s, 8c 7d, 8c 7h, 8c 7s, 8d 7c, 8d 7h, 8d 7s, 8h 7c, 8h 7d, 8h 7s, 8s 7c, 8s 7d, 8s 7h, 9c 7d, 9c 7h, 9c 7s, 9d 7c, 9d 7h, 9d 7s, 9h 7c, 9h 7d, 9h 7s, 9s 7c, 9s 7d, 9s 7h, Jc 6d, Jc 6h, Jc 6s, Jd 6c, Jd 6h, Jd 6s, Jh 6c, Jh 6d, Jh 6s, Js 6c, Js 6d, Js 6h, Qc 2d, Qc 2h, Qc 2s, Qd 2c, Qd 2h, Qd 2s, Qh 2c, Qh 2d, Qh 2s, Qs 2c, Qs 2d, Qs 2h, Tc 3c, Td 3d, Th 3h, Ts 3s, 6c 4c, 6d 4d, 6h 4h, 6s 4s, Jc 5d, Jc 5h, Jc 5s, Jd 5c, Jd 5h, Jd 5s, Jh 5c, Jh 5d, Jh 5s, Js 5c, Js 5d, Js 5h, 7c 4c, 7d 4d, 7h 4h, 7s 4s, Tc 2c, Td 2d, Th 2h, Ts 2s, 5c 3c, 5d 3d, 5h 3h, 5s 3s, Tc 6d, Tc 6h, Tc 6s, Td 6c, Td 6h, Td 6s, Th 6c, Th 6d, Th 6s, Ts 6c, Ts 6d, Ts 6h, 8c 4c, 8d 4d, 8h 4h, 8s 4s, 7c 6d, 7c 6h, 7c 6s, 7d 6c, 7d 6h, 7d 6s, 7h 6c, 7h 6d, 7h 6s, 7s 6c, 7s 6d, 7s 6h, 9c 4c, 9d 4d, 9h 4h, 9s 4s, Jc 4d, Jc 4h, Jc 4s, Jd 4c, Jd 4h, Jd 4s, Jh 4c, Jh 4d, Jh 4s, Js 4c, Js 4d, Js 4h, 8c 6d, 8c 6h, 8c 6s, 8d 6c, 8d 6h, 8d 6s, 8h 6c, 8h 6d, 8h 6s, 8s 6c, 8s 6d, 8s 6h, 9c 6d, 9c 6h, 9c 6s, 9d 6c, 9d 6h, 9d 6s, 9h 6c, 9h 6d, 9h 6s, 9s 6c, 9s 6d, 9s 6h, 4c 3c, 4d 3d, 4h 3h, 4s 3s, 9c 3c, 9d 3d, 9h 3h, 9s 3s, 6c 3c, 6d 3d, 6h 3h, 6s 3s, Jc 3d, Jc 3h, Jc 3s, Jd 3c, Jd 3h, Jd 3s, Jh 3c, Jh 3d, Jh 3s, Js 3c, Js 3d, Js 3h, 9c 2c, 9d 2d, 9h 2h, 9s 2s, 6c 5d, 6c 5h, 6c 5s, 6d 5c, 6d 5h, 6d 5s, 6h 5c, 6h 5d, 6h 5s, 6s 5c, 6s 5d, 6s 5h, 7c 3c, 7d 3d, 7h 3h, 7s 3s, 5c 2c, 5d 2d, 5h 2h, 5s 2s, Jc 2d, Jc 2h, Jc 2s, Jd 2c, Jd 2h, Jd 2s, Jh 2c, Jh 2d, Jh 2s, Js 2c, Js 2d, Js 2h, 8c 3c, 8d 3d, 8h 3h, 8s 3s, 7c 5d, 7c 5h, 7c 5s, 7d 5c, 7d 5h, 7d 5s, 7h 5c, 7h 5d, 7h 5s, 7s 5c, 7s 5d, 7s 5h, Tc 5d, Tc 5h, Tc 5s, Td 5c, Td 5h, Td 5s, Th 5c, Th 5d, Th 5s, Ts 5c, Ts 5d, Ts 5h, 5c 4d, 5c 4h, 5c 4s, 5d 4c, 5d 4h, 5d 4s, 5h 4c, 5h 4d, 5h 4s, 5s 4c, 5s 4d, 5s 4h, 8c 2c, 8d 2d, 8h 2h, 8s 2s, 8c 5d, 8c 5h, 8c 5s, 8d 5c, 8d 5h, 8d 5s, 8h 5c, 8h 5d, 8h 5s, 8s 5c, 8s 5d, 8s 5h, 4c 2c, 4d 2d, 4h 2h, 4s 2s, 9c 5d, 9c 5h, 9c 5s, 9d 5c, 9d 5h, 9d 5s, 9h 5c, 9h 5d, 9h 5s, 9s 5c, 9s 5d, 9s 5h, Tc 4d, Tc 4h, Tc 4s, Td 4c, Td 4h, Td 4s, Th 4c, Th 4d, Th 4s, Ts 4c, Ts 4d, Ts 4h, 6c 2c, 6d 2d, 6h 2h, 6s 2s, 3c 2c, 3d 2d, 3h 2h, 3s 2s, 6c 4d, 6c 4h, 6c 4s, 6d 4c, 6d 4h, 6d 4s, 6h 4c, 6h 4d, 6h 4s, 6s 4c, 6s 4d, 6s 4h, Tc 3d, Tc 3h, Tc 3s, Td 3c, Td 3h, Td 3s, Th 3c, Th 3d, Th 3s, Ts 3c, Ts 3d, Ts 3h, 7c 2c, 7d 2d, 7h 2h, 7s 2s, 7c 4d, 7c 4h, 7c 4s, 7d 4c, 7d 4h, 7d 4s, 7h 4c, 7h 4d, 7h 4s, 7s 4c, 7s 4d, 7s 4h, 5c 3d, 5c 3h, 5c 3s, 5d 3c, 5d 3h, 5d 3s, 5h 3c, 5h 3d, 5h 3s, 5s 3c, 5s 3d, 5s 3h, Tc 2d, Tc 2h, Tc 2s, Td 2c, Td 2h, Td 2s, Th 2c, Th 2d, Th 2s, Ts 2c, Ts 2d, Ts 2h, 8c 4d, 8c 4h, 8c 4s, 8d 4c, 8d 4h, 8d 4s, 8h 4c, 8h 4d, 8h 4s, 8s 4c, 8s 4d, 8s 4h, 9c 4d, 9c 4h, 9c 4s, 9d 4c, 9d 4h, 9d 4s, 9h 4c, 9h 4d, 9h 4s, 9s 4c, 9s 4d, 9s 4h, 4c 3d, 4c 3h, 4c 3s, 4d 3c, 4d 3h, 4d 3s, 4h 3c, 4h 3d, 4h 3s, 4s 3c, 4s 3d, 4s 3h, 9c 3d, 9c 3h, 9c 3s, 9d 3c, 9d 3h, 9d 3s, 9h 3c, 9h 3d, 9h 3s, 9s 3c, 9s 3d, 9s 3h, 6c 3d, 6c 3h, 6c 3s, 6d 3c, 6d 3h, 6d 3s, 6h 3c, 6h 3d, 6h 3s, 6s 3c, 6s 3d, 6s 3h, 9c 2d, 9c 2h, 9c 2s, 9d 2c, 9d 2h, 9d 2s, 9h 2c, 9h 2d, 9h 2s, 9s 2c, 9s 2d, 9s 2h, 7c 3d, 7c 3h, 7c 3s, 7d 3c, 7d 3h, 7d 3s, 7h 3c, 7h 3d, 7h 3s, 7s 3c, 7s 3d, 7s 3h, 5c 2d, 5c 2h, 5c 2s, 5d 2c, 5d 2h, 5d 2s, 5h 2c, 5h 2d, 5h 2s, 5s 2c, 5s 2d, 5s 2h, 8c 3d, 8c 3h, 8c 3s, 8d 3c, 8d 3h, 8d 3s, 8h 3c, 8h 3d, 8h 3s, 8s 3c, 8s 3d, 8s 3h, 8c 2d, 8c 2h, 8c 2s, 8d 2c, 8d 2h, 8d 2s, 8h 2c, 8h 2d, 8h 2s, 8s 2c, 8s 2d, 8s 2h, 4c 2d, 4c 2h, 4c 2s, 4d 2c, 4d 2h, 4d 2s, 4h 2c, 4h 2d, 4h 2s, 4s 2c, 4s 2d, 4s 2h, 6c 2d, 6c 2h, 6c 2s, 6d 2c, 6d 2h, 6d 2s, 6h 2c, 6h 2d, 6h 2s, 6s 2c, 6s 2d, 6s 2h, 3c 2d, 3c 2h, 3c 2s, 3d 2c, 3d 2h, 3d 2s, 3h 2c, 3h 2d, 3h 2s, 3s 2c, 3s 2d, 3s 2h, 7c 2d, 7c 2h, 7c 2s, 7d 2c, 7d 2h, 7d 2s, 7h 2c, 7h 2d, 7h 2s, 7s 2c, 7s 2d, 7s 2h".split("[,]");
	private static String[] RP_COMBOS = "Ac Ad, Ac Ah, Ac As, Ad Ah, Ad As, Ah As, Kc Kd, Kc Kh, Kc Ks, Kd Kh, Kd Ks, Kh Ks, Qc Qd, Qc Qh, Qc Qs, Qd Qh, Qd Qs, Qh Qs, Jc Jd, Jc Jh, Jc Js, Jd Jh, Jd Js, Jh Js, Ac Kc, Ad Kd, Ah Kh, As Ks, Tc Td, Tc Th, Tc Ts, Td Th, Td Ts, Th Ts, Ac Kd, Ac Kh, Ac Ks, Ad Kc, Ad Kh, Ad Ks, Ah Kc, Ah Kd, Ah Ks, As Kc, As Kd, As Kh, Ac Qc, Ad Qd, Ah Qh, As Qs, 9c 9d, 9c 9h, 9c 9s, 9d 9h, 9d 9s, 9h 9s, Ac Qd, Ac Qh, Ac Qs, Ad Qc, Ad Qh, Ad Qs, Ah Qc, Ah Qd, Ah Qs, As Qc, As Qd, As Qh, Ac Jc, Ad Jd, Ah Jh, As Js, 8c 8d, 8c 8h, 8c 8s, 8d 8h, 8d 8s, 8h 8s, Ac Jd, Ac Jh, Ac Js, Ad Jc, Ad Jh, Ad Js, Ah Jc, Ah Jd, Ah Js, As Jc, As Jd, As Jh, Ac Tc, Ad Td, Ah Th, As Ts, 7c 7d, 7c 7h, 7c 7s, 7d 7h, 7d 7s, 7h 7s, Ac Td, Ac Th, Ac Ts, Ad Tc, Ad Th, Ad Ts, Ah Tc, Ah Td, Ah Ts, As Tc, As Td, As Th, 6c 6d, 6c 6h, 6c 6s, 6d 6h, 6d 6s, 6h 6s, Ac 9c, Ad 9d, Ah 9h, As 9s, 5c 5d, 5c 5h, 5c 5s, 5d 5h, 5d 5s, 5h 5s, Kc Qc, Kd Qd, Kh Qh, Ks Qs, Ac 8c, Ad 8d, Ah 8h, As 8s, Ac 9d, Ac 9h, Ac 9s, Ad 9c, Ad 9h, Ad 9s, Ah 9c, Ah 9d, Ah 9s, As 9c, As 9d, As 9h, 4c 4d, 4c 4h, 4c 4s, 4d 4h, 4d 4s, 4h 4s, Kc Jc, Kd Jd, Kh Jh, Ks Js, Ac 7c, Ad 7d, Ah 7h, As 7s, Kc Qd, Kc Qh, Kc Qs, Kd Qc, Kd Qh, Kd Qs, Kh Qc, Kh Qd, Kh Qs, Ks Qc, Ks Qd, Ks Qh, 3c 3d, 3c 3h, 3c 3s, 3d 3h, 3d 3s, 3h 3s, Ac 8d, Ac 8h, Ac 8s, Ad 8c, Ad 8h, Ad 8s, Ah 8c, Ah 8d, Ah 8s, As 8c, As 8d, As 8h, Ac 5c, Ad 5d, Ah 5h, As 5s, Ac 6c, Ad 6d, Ah 6h, As 6s, Kc Tc, Kd Td, Kh Th, Ks Ts, 2c 2d, 2c 2h, 2c 2s, 2d 2h, 2d 2s, 2h 2s, Ac 4c, Ad 4d, Ah 4h, As 4s, Qc Jc, Qd Jd, Qh Jh, Qs Js, Ac 3c, Ad 3d, Ah 3h, As 3s, Kc Jd, Kc Jh, Kc Js, Kd Jc, Kd Jh, Kd Js, Kh Jc, Kh Jd, Kh Js, Ks Jc, Ks Jd, Ks Jh, Ac 7d, Ac 7h, Ac 7s, Ad 7c, Ad 7h, Ad 7s, Ah 7c, Ah 7d, Ah 7s, As 7c, As 7d, As 7h, Ac 2c, Ad 2d, Ah 2h, As 2s, Qc Tc, Qd Td, Qh Th, Qs Ts, Jc Tc, Jd Td, Jh Th, Js Ts, Kc 9c, Kd 9d, Kh 9h, Ks 9s, Ac 5d, Ac 5h, Ac 5s, Ad 5c, Ad 5h, Ad 5s, Ah 5c, Ah 5d, Ah 5s, As 5c, As 5d, As 5h, Ac 6d, Ac 6h, Ac 6s, Ad 6c, Ad 6h, Ad 6s, Ah 6c, Ah 6d, Ah 6s, As 6c, As 6d, As 6h, Kc Td, Kc Th, Kc Ts, Kd Tc, Kd Th, Kd Ts, Kh Tc, Kh Td, Kh Ts, Ks Tc, Ks Td, Ks Th, Tc 9c, Td 9d, Th 9h, Ts 9s, Jc 9c, Jd 9d, Jh 9h, Js 9s, Qc 9c, Qd 9d, Qh 9h, Qs 9s, Ac 4d, Ac 4h, Ac 4s, Ad 4c, Ad 4h, Ad 4s, Ah 4c, Ah 4d, Ah 4s, As 4c, As 4d, As 4h, Qc Jd, Qc Jh, Qc Js, Qd Jc, Qd Jh, Qd Js, Qh Jc, Qh Jd, Qh Js, Qs Jc, Qs Jd, Qs Jh, Ac 3d, Ac 3h, Ac 3s, Ad 3c, Ad 3h, Ad 3s, Ah 3c, Ah 3d, Ah 3s, As 3c, As 3d, As 3h, 9c 8c, 9d 8d, 9h 8h, 9s 8s, Kc 8c, Kd 8d, Kh 8h, Ks 8s, Tc 8c, Td 8d, Th 8h, Ts 8s, Ac 2d, Ac 2h, Ac 2s, Ad 2c, Ad 2h, Ad 2s, Ah 2c, Ah 2d, Ah 2s, As 2c, As 2d, As 2h, Kc 7c, Kd 7d, Kh 7h, Ks 7s, Qc Td, Qc Th, Qc Ts, Qd Tc, Qd Th, Qd Ts, Qh Tc, Qh Td, Qh Ts, Qs Tc, Qs Td, Qs Th, Jc Td, Jc Th, Jc Ts, Jd Tc, Jd Th, Jd Ts, Jh Tc, Jh Td, Jh Ts, Js Tc, Js Td, Js Th, 8c 7c, 8d 7d, 8h 7h, 8s 7s, Kc 6c, Kd 6d, Kh 6h, Ks 6s, Jc 8c, Jd 8d, Jh 8h, Js 8s, Qc 8c, Qd 8d, Qh 8h, Qs 8s, 9c 7c, 9d 7d, 9h 7h, 9s 7s, 7c 6c, 7d 6d, 7h 6h, 7s 6s, Kc 5c, Kd 5d, Kh 5h, Ks 5s, Kc 9d, Kc 9h, Kc 9s, Kd 9c, Kd 9h, Kd 9s, Kh 9c, Kh 9d, Kh 9s, Ks 9c, Ks 9d, Ks 9h, Tc 7c, Td 7d, Th 7h, Ts 7s, 8c 6c, 8d 6d, 8h 6h, 8s 6s, 6c 5c, 6d 5d, 6h 5h, 6s 5s, Kc 4c, Kd 4d, Kh 4h, Ks 4s, Tc 9d, Tc 9h, Tc 9s, Td 9c, Td 9h, Td 9s, Th 9c, Th 9d, Th 9s, Ts 9c, Ts 9d, Ts 9h, Jc 7c, Jd 7d, Jh 7h, Js 7s, Qc 6c, Qd 6d, Qh 6h, Qs 6s, Qc 7c, Qd 7d, Qh 7h, Qs 7s, 9c 6c, 9d 6d, 9h 6h, 9s 6s, Kc 3c, Kd 3d, Kh 3h, Ks 3s, Jc 9d, Jc 9h, Jc 9s, Jd 9c, Jd 9h, Jd 9s, Jh 9c, Jh 9d, Jh 9s, Js 9c, Js 9d, Js 9h, 5c 4c, 5d 4d, 5h 4h, 5s 4s, Qc 9d, Qc 9h, Qc 9s, Qd 9c, Qd 9h, Qd 9s, Qh 9c, Qh 9d, Qh 9s, Qs 9c, Qs 9d, Qs 9h, 7c 5c, 7d 5d, 7h 5h, 7s 5s, Qc 5c, Qd 5d, Qh 5h, Qs 5s, Kc 2c, Kd 2d, Kh 2h, Ks 2s, Tc 6c, Td 6d, Th 6h, Ts 6s, 9c 8d, 9c 8h, 9c 8s, 9d 8c, 9d 8h, 9d 8s, 9h 8c, 9h 8d, 9h 8s, 9s 8c, 9s 8d, 9s 8h, 8c 5c, 8d 5d, 8h 5h, 8s 5s, Jc 6c, Jd 6d, Jh 6h, Js 6s, Qc 4c, Qd 4d, Qh 4h, Qs 4s, Kc 8d, Kc 8h, Kc 8s, Kd 8c, Kd 8h, Kd 8s, Kh 8c, Kh 8d, Kh 8s, Ks 8c, Ks 8d, Ks 8h, 6c 4c, 6d 4d, 6h 4h, 6s 4s, Jc 5c, Jd 5d, Jh 5h, Js 5s, Tc 8d, Tc 8h, Tc 8s, Td 8c, Td 8h, Td 8s, Th 8c, Th 8d, Th 8s, Ts 8c, Ts 8d, Ts 8h, Qc 3c, Qd 3d, Qh 3h, Qs 3s, 9c 5c, 9d 5d, 9h 5h, 9s 5s, Kc 7d, Kc 7h, Kc 7s, Kd 7c, Kd 7h, Kd 7s, Kh 7c, Kh 7d, Kh 7s, Ks 7c, Ks 7d, Ks 7h, 8c 7d, 8c 7h, 8c 7s, 8d 7c, 8d 7h, 8d 7s, 8h 7c, 8h 7d, 8h 7s, 8s 7c, 8s 7d, 8s 7h, 5c 3c, 5d 3d, 5h 3h, 5s 3s, Jc 4c, Jd 4d, Jh 4h, Js 4s, Jc 8d, Jc 8h, Jc 8s, Jd 8c, Jd 8h, Jd 8s, Jh 8c, Jh 8d, Jh 8s, Js 8c, Js 8d, Js 8h, Kc 6d, Kc 6h, Kc 6s, Kd 6c, Kd 6h, Kd 6s, Kh 6c, Kh 6d, Kh 6s, Ks 6c, Ks 6d, Ks 6h, Qc 2c, Qd 2d, Qh 2h, Qs 2s, 7c 4c, 7d 4d, 7h 4h, 7s 4s, Qc 8d, Qc 8h, Qc 8s, Qd 8c, Qd 8h, Qd 8s, Qh 8c, Qh 8d, Qh 8s, Qs 8c, Qs 8d, Qs 8h, Tc 5c, Td 5d, Th 5h, Ts 5s, 9c 7d, 9c 7h, 9c 7s, 9d 7c, 9d 7h, 9d 7s, 9h 7c, 9h 7d, 9h 7s, 9s 7c, 9s 7d, 9s 7h, 7c 6d, 7c 6h, 7c 6s, 7d 6c, 7d 6h, 7d 6s, 7h 6c, 7h 6d, 7h 6s, 7s 6c, 7s 6d, 7s 6h, Jc 3c, Jd 3d, Jh 3h, Js 3s, Tc 4c, Td 4d, Th 4h, Ts 4s, 4c 3c, 4d 3d, 4h 3h, 4s 3s, Kc 5d, Kc 5h, Kc 5s, Kd 5c, Kd 5h, Kd 5s, Kh 5c, Kh 5d, Kh 5s, Ks 5c, Ks 5d, Ks 5h, 8c 4c, 8d 4d, 8h 4h, 8s 4s, 6c 3c, 6d 3d, 6h 3h, 6s 3s, Jc 2c, Jd 2d, Jh 2h, Js 2s, Tc 7d, Tc 7h, Tc 7s, Td 7c, Td 7h, Td 7s, Th 7c, Th 7d, Th 7s, Ts 7c, Ts 7d, Ts 7h, Tc 3c, Td 3d, Th 3h, Ts 3s, 8c 6d, 8c 6h, 8c 6s, 8d 6c, 8d 6h, 8d 6s, 8h 6c, 8h 6d, 8h 6s, 8s 6c, 8s 6d, 8s 6h, 6c 5d, 6c 5h, 6c 5s, 6d 5c, 6d 5h, 6d 5s, 6h 5c, 6h 5d, 6h 5s, 6s 5c, 6s 5d, 6s 5h, 9c 4c, 9d 4d, 9h 4h, 9s 4s, Kc 4d, Kc 4h, Kc 4s, Kd 4c, Kd 4h, Kd 4s, Kh 4c, Kh 4d, Kh 4s, Ks 4c, Ks 4d, Ks 4h, 5c 2c, 5d 2d, 5h 2h, 5s 2s, Tc 2c, Td 2d, Th 2h, Ts 2s, 9c 3c, 9d 3d, 9h 3h, 9s 3s, Jc 7d, Jc 7h, Jc 7s, Jd 7c, Jd 7h, Jd 7s, Jh 7c, Jh 7d, Jh 7s, Js 7c, Js 7d, Js 7h, 7c 3c, 7d 3d, 7h 3h, 7s 3s, Qc 6d, Qc 6h, Qc 6s, Qd 6c, Qd 6h, Qd 6s, Qh 6c, Qh 6d, Qh 6s, Qs 6c, Qs 6d, Qs 6h, 9c 6d, 9c 6h, 9c 6s, 9d 6c, 9d 6h, 9d 6s, 9h 6c, 9h 6d, 9h 6s, 9s 6c, 9s 6d, 9s 6h, Qc 7d, Qc 7h, Qc 7s, Qd 7c, Qd 7h, Qd 7s, Qh 7c, Qh 7d, Qh 7s, Qs 7c, Qs 7d, Qs 7h, 9c 2c, 9d 2d, 9h 2h, 9s 2s, Kc 3d, Kc 3h, Kc 3s, Kd 3c, Kd 3h, Kd 3s, Kh 3c, Kh 3d, Kh 3s, Ks 3c, Ks 3d, Ks 3h, 5c 4d, 5c 4h, 5c 4s, 5d 4c, 5d 4h, 5d 4s, 5h 4c, 5h 4d, 5h 4s, 5s 4c, 5s 4d, 5s 4h, 4c 2c, 4d 2d, 4h 2h, 4s 2s, 7c 5d, 7c 5h, 7c 5s, 7d 5c, 7d 5h, 7d 5s, 7h 5c, 7h 5d, 7h 5s, 7s 5c, 7s 5d, 7s 5h, 6c 2c, 6d 2d, 6h 2h, 6s 2s, 8c 3c, 8d 3d, 8h 3h, 8s 3s, Qc 5d, Qc 5h, Qc 5s, Qd 5c, Qd 5h, Qd 5s, Qh 5c, Qh 5d, Qh 5s, Qs 5c, Qs 5d, Qs 5h, Tc 6d, Tc 6h, Tc 6s, Td 6c, Td 6h, Td 6s, Th 6c, Th 6d, Th 6s, Ts 6c, Ts 6d, Ts 6h, 8c 2c, 8d 2d, 8h 2h, 8s 2s, Kc 2d, Kc 2h, Kc 2s, Kd 2c, Kd 2h, Kd 2s, Kh 2c, Kh 2d, Kh 2s, Ks 2c, Ks 2d, Ks 2h, 3c 2c, 3d 2d, 3h 2h, 3s 2s, 8c 5d, 8c 5h, 8c 5s, 8d 5c, 8d 5h, 8d 5s, 8h 5c, 8h 5d, 8h 5s, 8s 5c, 8s 5d, 8s 5h, Jc 6d, Jc 6h, Jc 6s, Jd 6c, Jd 6h, Jd 6s, Jh 6c, Jh 6d, Jh 6s, Js 6c, Js 6d, Js 6h, 6c 4d, 6c 4h, 6c 4s, 6d 4c, 6d 4h, 6d 4s, 6h 4c, 6h 4d, 6h 4s, 6s 4c, 6s 4d, 6s 4h, Qc 4d, Qc 4h, Qc 4s, Qd 4c, Qd 4h, Qd 4s, Qh 4c, Qh 4d, Qh 4s, Qs 4c, Qs 4d, Qs 4h, 7c 2c, 7d 2d, 7h 2h, 7s 2s, Jc 5d, Jc 5h, Jc 5s, Jd 5c, Jd 5h, Jd 5s, Jh 5c, Jh 5d, Jh 5s, Js 5c, Js 5d, Js 5h, 9c 5d, 9c 5h, 9c 5s, 9d 5c, 9d 5h, 9d 5s, 9h 5c, 9h 5d, 9h 5s, 9s 5c, 9s 5d, 9s 5h, Qc 3d, Qc 3h, Qc 3s, Qd 3c, Qd 3h, Qd 3s, Qh 3c, Qh 3d, Qh 3s, Qs 3c, Qs 3d, Qs 3h, 5c 3d, 5c 3h, 5c 3s, 5d 3c, 5d 3h, 5d 3s, 5h 3c, 5h 3d, 5h 3s, 5s 3c, 5s 3d, 5s 3h, Jc 4d, Jc 4h, Jc 4s, Jd 4c, Jd 4h, Jd 4s, Jh 4c, Jh 4d, Jh 4s, Js 4c, Js 4d, Js 4h, 7c 4d, 7c 4h, 7c 4s, 7d 4c, 7d 4h, 7d 4s, 7h 4c, 7h 4d, 7h 4s, 7s 4c, 7s 4d, 7s 4h, Qc 2d, Qc 2h, Qc 2s, Qd 2c, Qd 2h, Qd 2s, Qh 2c, Qh 2d, Qh 2s, Qs 2c, Qs 2d, Qs 2h, Tc 5d, Tc 5h, Tc 5s, Td 5c, Td 5h, Td 5s, Th 5c, Th 5d, Th 5s, Ts 5c, Ts 5d, Ts 5h, Jc 3d, Jc 3h, Jc 3s, Jd 3c, Jd 3h, Jd 3s, Jh 3c, Jh 3d, Jh 3s, Js 3c, Js 3d, Js 3h, Tc 4d, Tc 4h, Tc 4s, Td 4c, Td 4h, Td 4s, Th 4c, Th 4d, Th 4s, Ts 4c, Ts 4d, Ts 4h, 4c 3d, 4c 3h, 4c 3s, 4d 3c, 4d 3h, 4d 3s, 4h 3c, 4h 3d, 4h 3s, 4s 3c, 4s 3d, 4s 3h, 8c 4d, 8c 4h, 8c 4s, 8d 4c, 8d 4h, 8d 4s, 8h 4c, 8h 4d, 8h 4s, 8s 4c, 8s 4d, 8s 4h, 6c 3d, 6c 3h, 6c 3s, 6d 3c, 6d 3h, 6d 3s, 6h 3c, 6h 3d, 6h 3s, 6s 3c, 6s 3d, 6s 3h, Jc 2d, Jc 2h, Jc 2s, Jd 2c, Jd 2h, Jd 2s, Jh 2c, Jh 2d, Jh 2s, Js 2c, Js 2d, Js 2h, Tc 3d, Tc 3h, Tc 3s, Td 3c, Td 3h, Td 3s, Th 3c, Th 3d, Th 3s, Ts 3c, Ts 3d, Ts 3h, 9c 4d, 9c 4h, 9c 4s, 9d 4c, 9d 4h, 9d 4s, 9h 4c, 9h 4d, 9h 4s, 9s 4c, 9s 4d, 9s 4h, 5c 2d, 5c 2h, 5c 2s, 5d 2c, 5d 2h, 5d 2s, 5h 2c, 5h 2d, 5h 2s, 5s 2c, 5s 2d, 5s 2h, Tc 2d, Tc 2h, Tc 2s, Td 2c, Td 2h, Td 2s, Th 2c, Th 2d, Th 2s, Ts 2c, Ts 2d, Ts 2h, 9c 3d, 9c 3h, 9c 3s, 9d 3c, 9d 3h, 9d 3s, 9h 3c, 9h 3d, 9h 3s, 9s 3c, 9s 3d, 9s 3h, 7c 3d, 7c 3h, 7c 3s, 7d 3c, 7d 3h, 7d 3s, 7h 3c, 7h 3d, 7h 3s, 7s 3c, 7s 3d, 7s 3h, 9c 2d, 9c 2h, 9c 2s, 9d 2c, 9d 2h, 9d 2s, 9h 2c, 9h 2d, 9h 2s, 9s 2c, 9s 2d, 9s 2h, 4c 2d, 4c 2h, 4c 2s, 4d 2c, 4d 2h, 4d 2s, 4h 2c, 4h 2d, 4h 2s, 4s 2c, 4s 2d, 4s 2h, 6c 2d, 6c 2h, 6c 2s, 6d 2c, 6d 2h, 6d 2s, 6h 2c, 6h 2d, 6h 2s, 6s 2c, 6s 2d, 6s 2h, 8c 3d, 8c 3h, 8c 3s, 8d 3c, 8d 3h, 8d 3s, 8h 3c, 8h 3d, 8h 3s, 8s 3c, 8s 3d, 8s 3h, 8c 2d, 8c 2h, 8c 2s, 8d 2c, 8d 2h, 8d 2s, 8h 2c, 8h 2d, 8h 2s, 8s 2c, 8s 2d, 8s 2h, 3c 2d, 3c 2h, 3c 2s, 3d 2c, 3d 2h, 3d 2s, 3h 2c, 3h 2d, 3h 2s, 3s 2c, 3s 2d, 3s 2h, 7c 2d, 7c 2h, 7c 2s, 7d 2c, 7d 2h, 7d 2s, 7h 2c, 7h 2d, 7h 2s, 7s 2c, 7s 2d, 7s 2h".split("[,]");
	private static String[] RL_COMBOS = "Ac Ad, Ac Ah, Ac As, Ad Ah, Ad As, Ah As, Kc Kd, Kc Kh, Kc Ks, Kd Kh, Kd Ks, Kh Ks, Qc Qd, Qc Qh, Qc Qs, Qd Qh, Qd Qs, Qh Qs, Jc Jd, Jc Jh, Jc Js, Jd Jh, Jd Js, Jh Js, Ac Kc, Ad Kd, Ah Kh, As Ks, Ac Kd, Ac Kh, Ac Ks, Ad Kc, Ad Kh, Ad Ks, Ah Kc, Ah Kd, Ah Ks, As Kc, As Kd, As Kh, Tc Td, Tc Th, Tc Ts, Td Th, Td Ts, Th Ts, Ac Qc, Ad Qd, Ah Qh, As Qs, Ac Qd, Ac Qh, Ac Qs, Ad Qc, Ad Qh, Ad Qs, Ah Qc, Ah Qd, Ah Qs, As Qc, As Qd, As Qh, 9c 9d, 9c 9h, 9c 9s, 9d 9h, 9d 9s, 9h 9s, 8c 8d, 8c 8h, 8c 8s, 8d 8h, 8d 8s, 8h 8s, Ac Jc, Ad Jd, Ah Jh, As Js, 7c 7d, 7c 7h, 7c 7s, 7d 7h, 7d 7s, 7h 7s, Ac Jd, Ac Jh, Ac Js, Ad Jc, Ad Jh, Ad Js, Ah Jc, Ah Jd, Ah Js, As Jc, As Jd, As Jh, Ac Tc, Ad Td, Ah Th, As Ts, 6c 6d, 6c 6h, 6c 6s, 6d 6h, 6d 6s, 6h 6s, Ac Td, Ac Th, Ac Ts, Ad Tc, Ad Th, Ad Ts, Ah Tc, Ah Td, Ah Ts, As Tc, As Td, As Th, 5c 5d, 5c 5h, 5c 5s, 5d 5h, 5d 5s, 5h 5s, Kc Qc, Kd Qd, Kh Qh, Ks Qs, 4c 4d, 4c 4h, 4c 4s, 4d 4h, 4d 4s, 4h 4s, Ac 9c, Ad 9d, Ah 9h, As 9s, 3c 3d, 3c 3h, 3c 3s, 3d 3h, 3d 3s, 3h 3s, Kc Jc, Kd Jd, Kh Jh, Ks Js, Qc Jc, Qd Jd, Qh Jh, Qs Js, Jc Tc, Jd Td, Jh Th, Js Ts, Kc Tc, Kd Td, Kh Th, Ks Ts, 2c 2d, 2c 2h, 2c 2s, 2d 2h, 2d 2s, 2h 2s, Kc Qd, Kc Qh, Kc Qs, Kd Qc, Kd Qh, Kd Qs, Kh Qc, Kh Qd, Kh Qs, Ks Qc, Ks Qd, Ks Qh, Qc Tc, Qd Td, Qh Th, Qs Ts, Ac 8c, Ad 8d, Ah 8h, As 8s, Ac 9d, Ac 9h, Ac 9s, Ad 9c, Ad 9h, Ad 9s, Ah 9c, Ah 9d, Ah 9s, As 9c, As 9d, As 9h, Tc 9c, Td 9d, Th 9h, Ts 9s, Ac 7c, Ad 7d, Ah 7h, As 7s, Ac 5c, Ad 5d, Ah 5h, As 5s, Jc 9c, Jd 9d, Jh 9h, Js 9s, Kc 9c, Kd 9d, Kh 9h, Ks 9s, Qc 9c, Qd 9d, Qh 9h, Qs 9s, Tc 8c, Td 8d, Th 8h, Ts 8s, 9c 8c, 9d 8d, 9h 8h, 9s 8s, Ac 6c, Ad 6d, Ah 6h, As 6s, Ac 4c, Ad 4d, Ah 4h, As 4s, Ac 3c, Ad 3d, Ah 3h, As 3s, Ac 2c, Ad 2d, Ah 2h, As 2s, Jc 8c, Jd 8d, Jh 8h, Js 8s, 8c 7c, 8d 7d, 8h 7h, 8s 7s, Jc Td, Jc Th, Jc Ts, Jd Tc, Jd Th, Jd Ts, Jh Tc, Jh Td, Jh Ts, Js Tc, Js Td, Js Th, Qc Jd, Qc Jh, Qc Js, Qd Jc, Qd Jh, Qd Js, Qh Jc, Qh Jd, Qh Js, Qs Jc, Qs Jd, Qs Jh, Kc Jd, Kc Jh, Kc Js, Kd Jc, Kd Jh, Kd Js, Kh Jc, Kh Jd, Kh Js, Ks Jc, Ks Jd, Ks Jh, Qc 8c, Qd 8d, Qh 8h, Qs 8s, Kc 8c, Kd 8d, Kh 8h, Ks 8s, 7c 6c, 7d 6d, 7h 6h, 7s 6s, 9c 7c, 9d 7d, 9h 7h, 9s 7s, Tc 7c, Td 7d, Th 7h, Ts 7s, 8c 6c, 8d 6d, 8h 6h, 8s 6s, Jc 7c, Jd 7d, Jh 7h, Js 7s, Qc Td, Qc Th, Qc Ts, Qd Tc, Qd Th, Qd Ts, Qh Tc, Qh Td, Qh Ts, Qs Tc, Qs Td, Qs Th, Kc 7c, Kd 7d, Kh 7h, Ks 7s, Qc 7c, Qd 7d, Qh 7h, Qs 7s, Kc 6c, Kd 6d, Kh 6h, Ks 6s, Ac 8d, Ac 8h, Ac 8s, Ad 8c, Ad 8h, Ad 8s, Ah 8c, Ah 8d, Ah 8s, As 8c, As 8d, As 8h, Kc Td, Kc Th, Kc Ts, Kd Tc, Kd Th, Kd Ts, Kh Tc, Kh Td, Kh Ts, Ks Tc, Ks Td, Ks Th, 6c 5c, 6d 5d, 6h 5h, 6s 5s, 9c 6c, 9d 6d, 9h 6h, 9s 6s, Tc 9d, Tc 9h, Tc 9s, Td 9c, Td 9h, Td 9s, Th 9c, Th 9d, Th 9s, Ts 9c, Ts 9d, Ts 9h, Qc 6c, Qd 6d, Qh 6h, Qs 6s, Tc 6c, Td 6d, Th 6h, Ts 6s, Jc 6c, Jd 6d, Jh 6h, Js 6s, Kc 5c, Kd 5d, Kh 5h, Ks 5s, Ac 7d, Ac 7h, Ac 7s, Ad 7c, Ad 7h, Ad 7s, Ah 7c, Ah 7d, Ah 7s, As 7c, As 7d, As 7h, Kc 4c, Kd 4d, Kh 4h, Ks 4s, 7c 5c, 7d 5d, 7h 5h, 7s 5s, Ac 5d, Ac 5h, Ac 5s, Ad 5c, Ad 5h, Ad 5s, Ah 5c, Ah 5d, Ah 5s, As 5c, As 5d, As 5h, Jc 9d, Jc 9h, Jc 9s, Jd 9c, Jd 9h, Jd 9s, Jh 9c, Jh 9d, Jh 9s, Js 9c, Js 9d, Js 9h, Tc 8d, Tc 8h, Tc 8s, Td 8c, Td 8h, Td 8s, Th 8c, Th 8d, Th 8s, Ts 8c, Ts 8d, Ts 8h, Ac 6d, Ac 6h, Ac 6s, Ad 6c, Ad 6h, Ad 6s, Ah 6c, Ah 6d, Ah 6s, As 6c, As 6d, As 6h, 9c 8d, 9c 8h, 9c 8s, 9d 8c, 9d 8h, 9d 8s, 9h 8c, 9h 8d, 9h 8s, 9s 8c, 9s 8d, 9s 8h, Qc 5c, Qd 5d, Qh 5h, Qs 5s, Kc 3c, Kd 3d, Kh 3h, Ks 3s, Qc 9d, Qc 9h, Qc 9s, Qd 9c, Qd 9h, Qd 9s, Qh 9c, Qh 9d, Qh 9s, Qs 9c, Qs 9d, Qs 9h, Ac 4d, Ac 4h, Ac 4s, Ad 4c, Ad 4h, Ad 4s, Ah 4c, Ah 4d, Ah 4s, As 4c, As 4d, As 4h, 5c 4c, 5d 4d, 5h 4h, 5s 4s, 6c 4c, 6d 4d, 6h 4h, 6s 4s, 8c 5c, 8d 5d, 8h 5h, 8s 5s, 8c 7d, 8c 7h, 8c 7s, 8d 7c, 8d 7h, 8d 7s, 8h 7c, 8h 7d, 8h 7s, 8s 7c, 8s 7d, 8s 7h, Jc 8d, Jc 8h, Jc 8s, Jd 8c, Jd 8h, Jd 8s, Jh 8c, Jh 8d, Jh 8s, Js 8c, Js 8d, Js 8h, Kc 9d, Kc 9h, Kc 9s, Kd 9c, Kd 9h, Kd 9s, Kh 9c, Kh 9d, Kh 9s, Ks 9c, Ks 9d, Ks 9h, Ac 3d, Ac 3h, Ac 3s, Ad 3c, Ad 3h, Ad 3s, Ah 3c, Ah 3d, Ah 3s, As 3c, As 3d, As 3h, Ac 2d, Ac 2h, Ac 2s, Ad 2c, Ad 2h, Ad 2s, Ah 2c, Ah 2d, Ah 2s, As 2c, As 2d, As 2h, Jc 5c, Jd 5d, Jh 5h, Js 5s, Qc 4c, Qd 4d, Qh 4h, Qs 4s, Kc 2c, Kd 2d, Kh 2h, Ks 2s, Kc 8d, Kc 8h, Kc 8s, Kd 8c, Kd 8h, Kd 8s, Kh 8c, Kh 8d, Kh 8s, Ks 8c, Ks 8d, Ks 8h, Qc 3c, Qd 3d, Qh 3h, Qs 3s, 9c 5c, 9d 5d, 9h 5h, 9s 5s, Kc 7d, Kc 7h, Kc 7s, Kd 7c, Kd 7h, Kd 7s, Kh 7c, Kh 7d, Kh 7s, Ks 7c, Ks 7d, Ks 7h, 5c 3c, 5d 3d, 5h 3h, 5s 3s, Jc 4c, Jd 4d, Jh 4h, Js 4s, Kc 6d, Kc 6h, Kc 6s, Kd 6c, Kd 6h, Kd 6s, Kh 6c, Kh 6d, Kh 6s, Ks 6c, Ks 6d, Ks 6h, Qc 2c, Qd 2d, Qh 2h, Qs 2s, 7c 4c, 7d 4d, 7h 4h, 7s 4s, Qc 8d, Qc 8h, Qc 8s, Qd 8c, Qd 8h, Qd 8s, Qh 8c, Qh 8d, Qh 8s, Qs 8c, Qs 8d, Qs 8h, Tc 5c, Td 5d, Th 5h, Ts 5s, 9c 7d, 9c 7h, 9c 7s, 9d 7c, 9d 7h, 9d 7s, 9h 7c, 9h 7d, 9h 7s, 9s 7c, 9s 7d, 9s 7h, 7c 6d, 7c 6h, 7c 6s, 7d 6c, 7d 6h, 7d 6s, 7h 6c, 7h 6d, 7h 6s, 7s 6c, 7s 6d, 7s 6h, Jc 3c, Jd 3d, Jh 3h, Js 3s, Tc 4c, Td 4d, Th 4h, Ts 4s, 4c 3c, 4d 3d, 4h 3h, 4s 3s, Kc 5d, Kc 5h, Kc 5s, Kd 5c, Kd 5h, Kd 5s, Kh 5c, Kh 5d, Kh 5s, Ks 5c, Ks 5d, Ks 5h, 8c 4c, 8d 4d, 8h 4h, 8s 4s, 6c 3c, 6d 3d, 6h 3h, 6s 3s, Jc 2c, Jd 2d, Jh 2h, Js 2s, Tc 7d, Tc 7h, Tc 7s, Td 7c, Td 7h, Td 7s, Th 7c, Th 7d, Th 7s, Ts 7c, Ts 7d, Ts 7h, Tc 3c, Td 3d, Th 3h, Ts 3s, 8c 6d, 8c 6h, 8c 6s, 8d 6c, 8d 6h, 8d 6s, 8h 6c, 8h 6d, 8h 6s, 8s 6c, 8s 6d, 8s 6h, 6c 5d, 6c 5h, 6c 5s, 6d 5c, 6d 5h, 6d 5s, 6h 5c, 6h 5d, 6h 5s, 6s 5c, 6s 5d, 6s 5h, 9c 4c, 9d 4d, 9h 4h, 9s 4s, Kc 4d, Kc 4h, Kc 4s, Kd 4c, Kd 4h, Kd 4s, Kh 4c, Kh 4d, Kh 4s, Ks 4c, Ks 4d, Ks 4h, 5c 2c, 5d 2d, 5h 2h, 5s 2s, Tc 2c, Td 2d, Th 2h, Ts 2s, 9c 3c, 9d 3d, 9h 3h, 9s 3s, Jc 7d, Jc 7h, Jc 7s, Jd 7c, Jd 7h, Jd 7s, Jh 7c, Jh 7d, Jh 7s, Js 7c, Js 7d, Js 7h, 7c 3c, 7d 3d, 7h 3h, 7s 3s, Qc 6d, Qc 6h, Qc 6s, Qd 6c, Qd 6h, Qd 6s, Qh 6c, Qh 6d, Qh 6s, Qs 6c, Qs 6d, Qs 6h, 9c 6d, 9c 6h, 9c 6s, 9d 6c, 9d 6h, 9d 6s, 9h 6c, 9h 6d, 9h 6s, 9s 6c, 9s 6d, 9s 6h, Qc 7d, Qc 7h, Qc 7s, Qd 7c, Qd 7h, Qd 7s, Qh 7c, Qh 7d, Qh 7s, Qs 7c, Qs 7d, Qs 7h, 9c 2c, 9d 2d, 9h 2h, 9s 2s, Kc 3d, Kc 3h, Kc 3s, Kd 3c, Kd 3h, Kd 3s, Kh 3c, Kh 3d, Kh 3s, Ks 3c, Ks 3d, Ks 3h, 5c 4d, 5c 4h, 5c 4s, 5d 4c, 5d 4h, 5d 4s, 5h 4c, 5h 4d, 5h 4s, 5s 4c, 5s 4d, 5s 4h, 4c 2c, 4d 2d, 4h 2h, 4s 2s, 7c 5d, 7c 5h, 7c 5s, 7d 5c, 7d 5h, 7d 5s, 7h 5c, 7h 5d, 7h 5s, 7s 5c, 7s 5d, 7s 5h, 6c 2c, 6d 2d, 6h 2h, 6s 2s, 8c 3c, 8d 3d, 8h 3h, 8s 3s, Qc 5d, Qc 5h, Qc 5s, Qd 5c, Qd 5h, Qd 5s, Qh 5c, Qh 5d, Qh 5s, Qs 5c, Qs 5d, Qs 5h, Tc 6d, Tc 6h, Tc 6s, Td 6c, Td 6h, Td 6s, Th 6c, Th 6d, Th 6s, Ts 6c, Ts 6d, Ts 6h, 8c 2c, 8d 2d, 8h 2h, 8s 2s, Kc 2d, Kc 2h, Kc 2s, Kd 2c, Kd 2h, Kd 2s, Kh 2c, Kh 2d, Kh 2s, Ks 2c, Ks 2d, Ks 2h, 3c 2c, 3d 2d, 3h 2h, 3s 2s, 8c 5d, 8c 5h, 8c 5s, 8d 5c, 8d 5h, 8d 5s, 8h 5c, 8h 5d, 8h 5s, 8s 5c, 8s 5d, 8s 5h, Jc 6d, Jc 6h, Jc 6s, Jd 6c, Jd 6h, Jd 6s, Jh 6c, Jh 6d, Jh 6s, Js 6c, Js 6d, Js 6h, 6c 4d, 6c 4h, 6c 4s, 6d 4c, 6d 4h, 6d 4s, 6h 4c, 6h 4d, 6h 4s, 6s 4c, 6s 4d, 6s 4h, Qc 4d, Qc 4h, Qc 4s, Qd 4c, Qd 4h, Qd 4s, Qh 4c, Qh 4d, Qh 4s, Qs 4c, Qs 4d, Qs 4h, 7c 2c, 7d 2d, 7h 2h, 7s 2s, Jc 5d, Jc 5h, Jc 5s, Jd 5c, Jd 5h, Jd 5s, Jh 5c, Jh 5d, Jh 5s, Js 5c, Js 5d, Js 5h, 9c 5d, 9c 5h, 9c 5s, 9d 5c, 9d 5h, 9d 5s, 9h 5c, 9h 5d, 9h 5s, 9s 5c, 9s 5d, 9s 5h, Qc 3d, Qc 3h, Qc 3s, Qd 3c, Qd 3h, Qd 3s, Qh 3c, Qh 3d, Qh 3s, Qs 3c, Qs 3d, Qs 3h, 5c 3d, 5c 3h, 5c 3s, 5d 3c, 5d 3h, 5d 3s, 5h 3c, 5h 3d, 5h 3s, 5s 3c, 5s 3d, 5s 3h, Jc 4d, Jc 4h, Jc 4s, Jd 4c, Jd 4h, Jd 4s, Jh 4c, Jh 4d, Jh 4s, Js 4c, Js 4d, Js 4h, 7c 4d, 7c 4h, 7c 4s, 7d 4c, 7d 4h, 7d 4s, 7h 4c, 7h 4d, 7h 4s, 7s 4c, 7s 4d, 7s 4h, Qc 2d, Qc 2h, Qc 2s, Qd 2c, Qd 2h, Qd 2s, Qh 2c, Qh 2d, Qh 2s, Qs 2c, Qs 2d, Qs 2h, Tc 5d, Tc 5h, Tc 5s, Td 5c, Td 5h, Td 5s, Th 5c, Th 5d, Th 5s, Ts 5c, Ts 5d, Ts 5h, Jc 3d, Jc 3h, Jc 3s, Jd 3c, Jd 3h, Jd 3s, Jh 3c, Jh 3d, Jh 3s, Js 3c, Js 3d, Js 3h, Tc 4d, Tc 4h, Tc 4s, Td 4c, Td 4h, Td 4s, Th 4c, Th 4d, Th 4s, Ts 4c, Ts 4d, Ts 4h, 4c 3d, 4c 3h, 4c 3s, 4d 3c, 4d 3h, 4d 3s, 4h 3c, 4h 3d, 4h 3s, 4s 3c, 4s 3d, 4s 3h, 8c 4d, 8c 4h, 8c 4s, 8d 4c, 8d 4h, 8d 4s, 8h 4c, 8h 4d, 8h 4s, 8s 4c, 8s 4d, 8s 4h, 6c 3d, 6c 3h, 6c 3s, 6d 3c, 6d 3h, 6d 3s, 6h 3c, 6h 3d, 6h 3s, 6s 3c, 6s 3d, 6s 3h, Jc 2d, Jc 2h, Jc 2s, Jd 2c, Jd 2h, Jd 2s, Jh 2c, Jh 2d, Jh 2s, Js 2c, Js 2d, Js 2h, Tc 3d, Tc 3h, Tc 3s, Td 3c, Td 3h, Td 3s, Th 3c, Th 3d, Th 3s, Ts 3c, Ts 3d, Ts 3h, 9c 4d, 9c 4h, 9c 4s, 9d 4c, 9d 4h, 9d 4s, 9h 4c, 9h 4d, 9h 4s, 9s 4c, 9s 4d, 9s 4h, 5c 2d, 5c 2h, 5c 2s, 5d 2c, 5d 2h, 5d 2s, 5h 2c, 5h 2d, 5h 2s, 5s 2c, 5s 2d, 5s 2h, Tc 2d, Tc 2h, Tc 2s, Td 2c, Td 2h, Td 2s, Th 2c, Th 2d, Th 2s, Ts 2c, Ts 2d, Ts 2h, 9c 3d, 9c 3h, 9c 3s, 9d 3c, 9d 3h, 9d 3s, 9h 3c, 9h 3d, 9h 3s, 9s 3c, 9s 3d, 9s 3h, 7c 3d, 7c 3h, 7c 3s, 7d 3c, 7d 3h, 7d 3s, 7h 3c, 7h 3d, 7h 3s, 7s 3c, 7s 3d, 7s 3h, 9c 2d, 9c 2h, 9c 2s, 9d 2c, 9d 2h, 9d 2s, 9h 2c, 9h 2d, 9h 2s, 9s 2c, 9s 2d, 9s 2h, 4c 2d, 4c 2h, 4c 2s, 4d 2c, 4d 2h, 4d 2s, 4h 2c, 4h 2d, 4h 2s, 4s 2c, 4s 2d, 4s 2h, 6c 2d, 6c 2h, 6c 2s, 6d 2c, 6d 2h, 6d 2s, 6h 2c, 6h 2d, 6h 2s, 6s 2c, 6s 2d, 6s 2h, 8c 3d, 8c 3h, 8c 3s, 8d 3c, 8d 3h, 8d 3s, 8h 3c, 8h 3d, 8h 3s, 8s 3c, 8s 3d, 8s 3h, 8c 2d, 8c 2h, 8c 2s, 8d 2c, 8d 2h, 8d 2s, 8h 2c, 8h 2d, 8h 2s, 8s 2c, 8s 2d, 8s 2h, 3c 2d, 3c 2h, 3c 2s, 3d 2c, 3d 2h, 3d 2s, 3h 2c, 3h 2d, 3h 2s, 3s 2c, 3s 2d, 3s 2h, 7c 2d, 7c 2h, 7c 2s, 7d 2c, 7d 2h, 7d 2s, 7h 2c, 7h 2d, 7h 2s, 7s 2c, 7s 2d, 7s 2h".split("[,]");
	char rankType = 0;
	
	public void add (String s){
		String[] result = s.split("[,]");
	    for (int x=0; x<result.length; x++) {
	         addShort(result[x]);
	    }
	}
	
	public void addSpaces (String s){
		String[] result = s.split("\\s");
	    for (int x=0; x<result.length; x++) {
	         addShort(result[x].trim());
	    }
	}
	
	private void addShort (String s) throws RuntimeException {
		Rank r1;
		Rank r2;
		switch (s.length()) {
			
			case 2: {
				r1 = new Rank(s.charAt(0));
				r2 = new Rank(s.charAt(1));
				if (r1.value() == r2.value()) {
					for (int x=0; x<4; x++) {
						for (int y=0; y<4; y++) {
							if (x != y) {
							addInts(r1.value()+(13*x),r2.value()+(13*y));
							}
						}
					}					
				}
				break;
			}
			
			case 3: {
				r1 = new Rank(s.charAt(0));
				r2 = new Rank(s.charAt(1));
				if (s.contains("o")) {
					for (int x=0; x<4; x++) {
						for (int y=0; y<4; y++) {
							if (x != y) {
							addInts(r1.value()+(13*x),r2.value()+(13*y));
							}
						}
					}
				} else if (s.contains("s")) {
					for (int x=0; x<4; x++) {
							addInts(r1.value()+(13*x),r2.value()+(13*x));
					}
				} else if (s.charAt(0) == 'R') {
					int topnum = Integer.parseInt(s.charAt(2) + "");
					float percentile = (float) (topnum / 100.0);
					if (s.charAt(1) == 'P') {
						    for (int x=0; x<RP_COMBOS.length*percentile; x++) {
						    	add(new Hand(RP_COMBOS[x]));
						    }
						this.rankType = 'P';
					} else if (s.charAt(1) == 'C') {
							for (int x=0; x<RC_COMBOS.length*percentile; x++) {
								add(new Hand(RC_COMBOS[x]));
						    }
						this.rankType = 'C';
					} else if (s.charAt(1) == 'L') {
							for (int x=0; x<RL_COMBOS.length*percentile; x++) {
								add(new Hand(RL_COMBOS[x]));
						    }
						this.rankType = 'L';
					}
					
				}
				
				else {
					throw new RuntimeException();
				}
				break;
			}
			
			case 4: {
				if (s.contains("+")) {
					r1 = new Rank(s.charAt(0));
					r2 = new Rank(s.charAt(1));
					if (s.contains("o")) {
						for (int x=0; x<4; x++) {
							for (int y=0; y<4; y++) {
								addInts(r1.value()+(13*x),r2.value()+(13*y));
							}
						}
					} else if (s.contains("s")) {
						for (int x=0; x<4; x++) {
								addInts(r1.value()+(13*x),r2.value()+(13*x));
						}
					} else {
						throw new RuntimeException();
					}
				} else if (s.charAt(0) == 'R') {
					String num = Character.toString(s.charAt(2)) + Character.toString(s.charAt(3));
					float topnum = Float.parseFloat(num);
					float percentile = (float) (topnum / 100.0);
					if (s.charAt(1) == 'P') {
						    for (int x=0; x<RP_COMBOS.length*percentile; x++) {
						    	add(new Hand(RP_COMBOS[x]));
						    }
						this.rankType = 'P';
					} else if (s.charAt(1) == 'C') {
							for (int x=0; x<RC_COMBOS.length*percentile; x++) {
								add(new Hand(RC_COMBOS[x]));
						    }
						this.rankType = 'C';
					} else if (s.charAt(1) == 'L') {
							for (int x=0; x<RL_COMBOS.length*percentile; x++) {
								add(new Hand(RL_COMBOS[x]));
						    }
						this.rankType = 'L';
					}
					
				} else {
					addString(s);
				}
				break;
			}
			
		}
		
	}
	
	private void addString (String s) {
		Hand h = new Hand(s);
		for (int x=0;x<this.size();x++){
			if (h.equals(this.get(x))) {
				return;
			}
		}
		super.add(h);
	}
	
	private void addInts (int a, int b) {
		Hand h = new Hand(a,b);
		for (int x=0;x<this.size();x++){
			if (h.equals(this.get(x))) {
				return;
			}
		}
		super.add(h);
	}
	
	public void addCombos (int n) {
		switch (this.rankType){
		case 'P': 
			    for (int x=0; x<n; x++) {
			         add(new Hand(RP_COMBOS[this.size()]));
			    }
		case 'C': 
			    for (int x=0; x<n; x++) {
			    	add(new Hand(RC_COMBOS[this.size()]));
			    }
		case 'L':
			    for (int x=0; x<n; x++) {
			    	add(new Hand(RL_COMBOS[this.size()]));
			    }
		}
	}
	
	public void subtractCombos (int n) {
		for (int x=0; x<n; x++) {
			this.remove(this.size()-1);
		}
	}
	
	public Range getBottom (int n) {
		Range k = new Range();
		for (int x=1; x<n+1; x++) {
			k.add(this.get(this.size()-x));
		}
		return k;
	}
	
	/*public static void main (String[] args) {
		Range a = new Range();
		try {
		    for (int x=0; x<RL_SPLIT.length; x++) {
		         a.addShort(RL_SPLIT[x].trim());
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println(a.toString());
	}*/
	
	
}
