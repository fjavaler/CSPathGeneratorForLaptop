package com;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Controller implements ActionListener
{
	private Semester blank = new Semester("Choose semester");
	private Semester spring2015 = new Semester("Spring", 2015);
	private Semester summer2015 = new Semester("Summer", 2015);
	private Semester fall2015 = new Semester("Fall", 2015);
	private Semester spring2016 = new Semester("Spring", 2016);
	private Semester summer2016 = new Semester("Summer", 2016);
	private Semester fall2016 = new Semester("Fall", 2016);
	private Semester spring2017 = new Semester("Spring", 2017);
	private Semester summer2017 = new Semester("Summer", 2017);
	private Semester fall2017 = new Semester("Fall", 2017);
	private Semester spring2018 = new Semester("Spring", 2018);
	private Semester summer2018 = new Semester("Summer", 2018);
	private Semester fall2018 = new Semester("Fall", 2018);
	private Semester spring2019 = new Semester("Spring", 2019);
	private Semester summer2019 = new Semester("Summer", 2019);
	private Semester fall2019 = new Semester("Fall", 2019);
	private Semester spring2020 = new Semester("Spring", 2020);

	private Course cs2420 = new Course("CS", 2420, "Computer Science II", 4,
			null, false, blank);
	private Course phil4010 = new Course("PHIL", 4010, "Senior Seminar", 3,
			null, false, blank);
	private Course cs2100 = new Course("CS", 2100, "Discrete Structures", 3,
			null, false, blank);
	private Course chem1210 = new Course("CHEM", 1210, "General Chemistry I",
			4, null, false, blank);
	private Course cs3130 = new Course("CS", 3130,
			"Engineering Probability and Statistics", 3, null, true, blank);
	private Course cs3500 = new Course("CS", 3500, "Software Practice I", 4,
			null, true, blank);
	private Course cs3505 = new Course("CS", 3505, "Software Practice II", 3,
			new HashSet<Course>()
			{
				{
					add(cs3500);
				}
			}, true, blank);
	private Course cs3810 = new Course("CS", 3810, "Computer Organization", 3,
			null, true, blank);
	private Course cs4400 = new Course("CS", 4400, "Computer Systems", 4,
			new HashSet<Course>()
			{
				{
					add(cs3810);
				}
			}, true, blank);
	private Course cs4150 = new Course("CS", 4150, "Algorithms", 3,
			new HashSet<Course>()
			{
				{
					add(cs2100);
				}
			}, true, blank);
	private Course cs3100 = new Course("CS", 3100, "Models of Computation", 3,
			new HashSet<Course>()
			{
				{
					add(cs2100);
				}
			}, true, blank);
	private Course cs4940 = new Course("CS", 4940, "Undergraduate Research", 3,
			null, null, true, blank);
	private Course cs4970 = new Course("CS", 4970,
			"Computer Science Bachelor's Thesis", 3, new HashSet<Course>()
			{
				{
					add(cs4940);
				}
			}, null, true, blank);
	private Course csElective1 = new Course("CS", 0001, "Elective", 3, null,
			true, blank);
	private Course csElective2 = new Course("CS", 0002, "Elective", 3, null,
			true, blank);
	private Course csElective3 = new Course("CS", 0003, "Elective", 3, null,
			true, blank);
	private Course csElective4 = new Course("CS", 0004, "Elective", 3, null,
			true, blank);
	private Course csElective5 = new Course("CS", 0005, "Elective", 3, null,
			true, blank);
	private Course csElective6 = new Course("CS", 0006, "Elective", 3, null,
			true, blank);

	private String[] semesterNames;
	private Course[] coursesLeft;
	private Semester[] semesters;
	private GUI gui;

	public Controller(GUI _gui)
	{
		coursesLeft = new Course[]
		{ cs2420, phil4010, cs2100, chem1210, cs3130, cs3500, cs3505, cs3810,
				cs4150, cs4400, cs4940, cs4970, cs3100, csElective1,
				csElective2, csElective3, csElective4, csElective5, csElective6};

		semesters = new Semester[]
		{ spring2015, summer2015, fall2015, spring2016, summer2016, fall2016,
				spring2017, summer2017, fall2017, spring2018, summer2018,
				fall2018, spring2019, summer2019, fall2019, spring2020 };

		semesterNames = new String[]
		{ blank.getFormattedName(), spring2015.getFormattedName(),
				summer2015.getFormattedName(), fall2015.getFormattedName(),
				spring2016.getFormattedName(), summer2016.getFormattedName(),
				fall2016.getFormattedName(), spring2017.getFormattedName(),
				summer2017.getFormattedName(), fall2017.getFormattedName(),
				spring2018.getFormattedName(), summer2018.getFormattedName(),
				fall2018.getFormattedName(), spring2019.getFormattedName(),
				summer2019.getFormattedName(), fall2019.getFormattedName(),
				spring2020.getFormattedName() };

		gui = _gui;
	}

	public Course[] getCoursesLeft()
	{
		return coursesLeft;
	}

	public String[] getSemesterNames()
	{
		return semesterNames;
	}

	public Semester[] getSemesters()
	{
		return semesters;
	}

	public Course getCourse(Course target)
	{
		for (Course c : coursesLeft)
		{
			if (c == target)
			{
				return c;
			}
		}
		return null;
	}

	public Course getCourseFromCourseName(String courseName)
	{
		for (Course c : coursesLeft)
		{
			if (c.getShortTitle().equals(courseName))
			{
				return c;
			}
		}
		return null;
	}

	public Semester getSemester(Semester target)
	{
		for (Semester s : semesters)
		{
			if (s == target)
			{
				return s;
			}
		}
		return null;
	}

	public void addACourseToSemesterSchedule(Course course, Semester semester)
	{
		getSemester(semester).getSemesterSchedule().addACourse(course);
	}

	public void removeACourseFromSemesterSchedule(Course course,
			Semester semester)
	{
		getSemester(semester).getSemesterSchedule().removeACourse(course);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() instanceof JComboBox)
		{
			@SuppressWarnings("unchecked")
			JComboBox<String> box = (JComboBox<String>) e.getSource();
			String selectedSemester = (String) box.getSelectedItem();

			if (selectedSemester.equals("Spring2015"))
			{
				Semester comparison = getCourseFromCourseName(box.getName())
						.getSemesterTaken();
				if (comparison == blank)
				{
					// adds the course to the semesterSchecule
					addACourseToSemesterSchedule(
							getCourseFromCourseName(box.getName()), spring2015);
					getCourseFromCourseName(box.getName()).setSemesterTaken(
							spring2015);
					gui.getJEditorPane(spring2015).setText(
							getSemester(spring2015).getSemesterSchedule()
									.printSchedule());
					gui.repaint();
				} else if (comparison != spring2015)
				{
					Semester old = getCourseFromCourseName(box.getName())
							.getSemesterTaken();
					removeACourseFromSemesterSchedule(
							getCourseFromCourseName(box.getName()),
							getCourseFromCourseName(box.getName())
									.getSemesterTaken());
					gui.getJEditorPane(old).setText(
							getSemester(old).getSemesterSchedule()
									.printSchedule());
					// adds the course to the semesterSchecule
					addACourseToSemesterSchedule(
							getCourseFromCourseName(box.getName()), spring2015);
					getCourseFromCourseName(box.getName()).setSemesterTaken(
							spring2015);
					gui.getJEditorPane(spring2015).setText(
							getSemester(spring2015).getSemesterSchedule()
									.printSchedule());
					gui.repaint();
				}
			} else if (selectedSemester.equals("Summer2015"))
			{
				Semester comparison = getCourseFromCourseName(box.getName())
						.getSemesterTaken();
				if (comparison == blank)
				{
					// adds the course to the semesterSchecule
					addACourseToSemesterSchedule(
							getCourseFromCourseName(box.getName()), summer2015);
					getCourseFromCourseName(box.getName()).setSemesterTaken(
							summer2015);
					gui.getJEditorPane(summer2015).setText(
							getSemester(summer2015).getSemesterSchedule()
									.printSchedule());
					gui.repaint();
				} else if (comparison != summer2015)
				{
					Semester old = getCourseFromCourseName(box.getName())
							.getSemesterTaken();
					removeACourseFromSemesterSchedule(
							getCourseFromCourseName(box.getName()),
							getCourseFromCourseName(box.getName())
									.getSemesterTaken());
					gui.getJEditorPane(old).setText(
							getSemester(old).getSemesterSchedule()
									.printSchedule());
					// adds the course to the semesterSchecule
					addACourseToSemesterSchedule(
							getCourseFromCourseName(box.getName()), summer2015);
					getCourseFromCourseName(box.getName()).setSemesterTaken(
							summer2015);
					gui.getJEditorPane(summer2015).setText(
							getSemester(summer2015).getSemesterSchedule()
									.printSchedule());
					gui.repaint();
				}
			} else if (selectedSemester.equals("Fall2015"))
			{
				Semester comparison = getCourseFromCourseName(box.getName())
						.getSemesterTaken();
				if (comparison == blank)
				{
					// adds the course to the semesterSchecule
					addACourseToSemesterSchedule(
							getCourseFromCourseName(box.getName()), fall2015);
					getCourseFromCourseName(box.getName()).setSemesterTaken(
							fall2015);
					gui.getJEditorPane(fall2015).setText(
							getSemester(fall2015).getSemesterSchedule()
									.printSchedule());
					gui.repaint();
				} else if (comparison != fall2015)
				{
					Semester old = getCourseFromCourseName(box.getName())
							.getSemesterTaken();
					removeACourseFromSemesterSchedule(
							getCourseFromCourseName(box.getName()),
							getCourseFromCourseName(box.getName())
									.getSemesterTaken());
					gui.getJEditorPane(old).setText(
							getSemester(old).getSemesterSchedule()
									.printSchedule());
					// adds the course to the semesterSchecule
					addACourseToSemesterSchedule(
							getCourseFromCourseName(box.getName()), fall2015);
					getCourseFromCourseName(box.getName()).setSemesterTaken(
							fall2015);
					gui.getJEditorPane(fall2015).setText(
							getSemester(fall2015).getSemesterSchedule()
									.printSchedule());
					gui.repaint();
				}
			}

			if (selectedSemester.equals("Spring2016"))
			{
				Semester comparison = getCourseFromCourseName(box.getName())
						.getSemesterTaken();
				if (comparison == blank)
				{
					// adds the course to the semesterSchecule
					addACourseToSemesterSchedule(
							getCourseFromCourseName(box.getName()), spring2016);
					getCourseFromCourseName(box.getName()).setSemesterTaken(
							spring2016);
					gui.getJEditorPane(spring2016).setText(
							getSemester(spring2016).getSemesterSchedule()
									.printSchedule());
					gui.repaint();
				} else if (comparison != spring2016)
				{
					Semester old = getCourseFromCourseName(box.getName())
							.getSemesterTaken();
					removeACourseFromSemesterSchedule(
							getCourseFromCourseName(box.getName()),
							getCourseFromCourseName(box.getName())
									.getSemesterTaken());
					gui.getJEditorPane(old).setText(
							getSemester(old).getSemesterSchedule()
									.printSchedule());
					// adds the course to the semesterSchecule
					addACourseToSemesterSchedule(
							getCourseFromCourseName(box.getName()), spring2016);
					getCourseFromCourseName(box.getName()).setSemesterTaken(
							spring2016);
					gui.getJEditorPane(spring2016).setText(
							getSemester(spring2016).getSemesterSchedule()
									.printSchedule());
					gui.repaint();
				}
			} else if (selectedSemester.equals("Summer2016"))
			{
				Semester comparison = getCourseFromCourseName(box.getName())
						.getSemesterTaken();
				if (comparison == blank)
				{
					// adds the course to the semesterSchecule
					addACourseToSemesterSchedule(
							getCourseFromCourseName(box.getName()), summer2016);
					getCourseFromCourseName(box.getName()).setSemesterTaken(
							summer2016);
					gui.getJEditorPane(summer2016).setText(
							getSemester(summer2016).getSemesterSchedule()
									.printSchedule());
					gui.repaint();
				} else if (comparison != summer2016)
				{
					Semester old = getCourseFromCourseName(box.getName())
							.getSemesterTaken();
					removeACourseFromSemesterSchedule(
							getCourseFromCourseName(box.getName()),
							getCourseFromCourseName(box.getName())
									.getSemesterTaken());
					gui.getJEditorPane(old).setText(
							getSemester(old).getSemesterSchedule()
									.printSchedule());
					// adds the course to the semesterSchecule
					addACourseToSemesterSchedule(
							getCourseFromCourseName(box.getName()), summer2016);
					getCourseFromCourseName(box.getName()).setSemesterTaken(
							summer2016);
					gui.getJEditorPane(summer2016).setText(
							getSemester(summer2016).getSemesterSchedule()
									.printSchedule());
					gui.repaint();
				}
			} else if (selectedSemester.equals("Fall2016"))
			{
				Semester comparison = getCourseFromCourseName(box.getName())
						.getSemesterTaken();
				if (comparison == blank)
				{
					// adds the course to the semesterSchecule
					addACourseToSemesterSchedule(
							getCourseFromCourseName(box.getName()), fall2016);
					getCourseFromCourseName(box.getName()).setSemesterTaken(
							fall2016);
					gui.getJEditorPane(fall2016).setText(
							getSemester(fall2016).getSemesterSchedule()
									.printSchedule());
					gui.repaint();
				} else if (comparison != fall2016)
				{
					Semester old = getCourseFromCourseName(box.getName())
							.getSemesterTaken();
					removeACourseFromSemesterSchedule(
							getCourseFromCourseName(box.getName()),
							getCourseFromCourseName(box.getName())
									.getSemesterTaken());
					gui.getJEditorPane(old).setText(
							getSemester(old).getSemesterSchedule()
									.printSchedule());
					// adds the course to the semesterSchecule
					addACourseToSemesterSchedule(
							getCourseFromCourseName(box.getName()), fall2016);
					getCourseFromCourseName(box.getName()).setSemesterTaken(
							fall2016);
					gui.getJEditorPane(fall2016).setText(
							getSemester(fall2016).getSemesterSchedule()
									.printSchedule());
					gui.repaint();
				}
			}

			if (selectedSemester.equals("Spring2017"))
			{
				Semester comparison = getCourseFromCourseName(box.getName())
						.getSemesterTaken();
				if (comparison == blank)
				{
					// adds the course to the semesterSchecule
					addACourseToSemesterSchedule(
							getCourseFromCourseName(box.getName()), spring2017);
					getCourseFromCourseName(box.getName()).setSemesterTaken(
							spring2017);
					gui.getJEditorPane(spring2017).setText(
							getSemester(spring2017).getSemesterSchedule()
									.printSchedule());
					gui.repaint();
				} else if (comparison != spring2017)
				{
					Semester old = getCourseFromCourseName(box.getName())
							.getSemesterTaken();
					removeACourseFromSemesterSchedule(
							getCourseFromCourseName(box.getName()),
							getCourseFromCourseName(box.getName())
									.getSemesterTaken());
					gui.getJEditorPane(old).setText(
							getSemester(old).getSemesterSchedule()
									.printSchedule());
					// adds the course to the semesterSchecule
					addACourseToSemesterSchedule(
							getCourseFromCourseName(box.getName()), spring2017);
					getCourseFromCourseName(box.getName()).setSemesterTaken(
							spring2017);
					gui.getJEditorPane(spring2017).setText(
							getSemester(spring2017).getSemesterSchedule()
									.printSchedule());
					gui.repaint();
				}
			} else if (selectedSemester.equals("Summer2017"))
			{
				Semester comparison = getCourseFromCourseName(box.getName())
						.getSemesterTaken();
				if (comparison == blank)
				{
					// adds the course to the semesterSchecule
					addACourseToSemesterSchedule(
							getCourseFromCourseName(box.getName()), summer2017);
					getCourseFromCourseName(box.getName()).setSemesterTaken(
							summer2017);
					gui.getJEditorPane(summer2017).setText(
							getSemester(summer2017).getSemesterSchedule()
									.printSchedule());
					gui.repaint();
				} else if (comparison != summer2017)
				{
					Semester old = getCourseFromCourseName(box.getName())
							.getSemesterTaken();
					removeACourseFromSemesterSchedule(
							getCourseFromCourseName(box.getName()),
							getCourseFromCourseName(box.getName())
									.getSemesterTaken());
					gui.getJEditorPane(old).setText(
							getSemester(old).getSemesterSchedule()
									.printSchedule());
					// adds the course to the semesterSchecule
					addACourseToSemesterSchedule(
							getCourseFromCourseName(box.getName()), summer2017);
					getCourseFromCourseName(box.getName()).setSemesterTaken(
							summer2017);
					gui.getJEditorPane(summer2017).setText(
							getSemester(summer2017).getSemesterSchedule()
									.printSchedule());
					gui.repaint();
				}
			} else if (selectedSemester.equals("Fall2017"))
			{
				Semester comparison = getCourseFromCourseName(box.getName())
						.getSemesterTaken();
				if (comparison == blank)
				{
					// adds the course to the semesterSchecule
					addACourseToSemesterSchedule(
							getCourseFromCourseName(box.getName()), fall2017);
					getCourseFromCourseName(box.getName()).setSemesterTaken(
							fall2017);
					gui.getJEditorPane(fall2017).setText(
							getSemester(fall2017).getSemesterSchedule()
									.printSchedule());
					gui.repaint();
				} else if (comparison != fall2017)
				{
					Semester old = getCourseFromCourseName(box.getName())
							.getSemesterTaken();
					removeACourseFromSemesterSchedule(
							getCourseFromCourseName(box.getName()),
							getCourseFromCourseName(box.getName())
									.getSemesterTaken());
					gui.getJEditorPane(old).setText(
							getSemester(old).getSemesterSchedule()
									.printSchedule());
					// adds the course to the semesterSchecule
					addACourseToSemesterSchedule(
							getCourseFromCourseName(box.getName()), fall2017);
					getCourseFromCourseName(box.getName()).setSemesterTaken(
							fall2017);
					gui.getJEditorPane(fall2017).setText(
							getSemester(fall2017).getSemesterSchedule()
									.printSchedule());
					gui.repaint();
				}
			}

			if (selectedSemester.equals("Spring2018"))
			{
				Semester comparison = getCourseFromCourseName(box.getName())
						.getSemesterTaken();
				if (comparison == blank)
				{
					// adds the course to the semesterSchecule
					addACourseToSemesterSchedule(
							getCourseFromCourseName(box.getName()), spring2018);
					getCourseFromCourseName(box.getName()).setSemesterTaken(
							spring2018);
					gui.getJEditorPane(spring2018).setText(
							getSemester(spring2018).getSemesterSchedule()
									.printSchedule());
					gui.repaint();
				} else if (comparison != spring2018)
				{
					Semester old = getCourseFromCourseName(box.getName())
							.getSemesterTaken();
					removeACourseFromSemesterSchedule(
							getCourseFromCourseName(box.getName()),
							getCourseFromCourseName(box.getName())
									.getSemesterTaken());
					gui.getJEditorPane(old).setText(
							getSemester(old).getSemesterSchedule()
									.printSchedule());
					// adds the course to the semesterSchecule
					addACourseToSemesterSchedule(
							getCourseFromCourseName(box.getName()), spring2018);
					getCourseFromCourseName(box.getName()).setSemesterTaken(
							spring2018);
					gui.getJEditorPane(spring2018).setText(
							getSemester(spring2018).getSemesterSchedule()
									.printSchedule());
					gui.repaint();
				}
			} else if (selectedSemester.equals("Summer2018"))
			{
				Semester comparison = getCourseFromCourseName(box.getName())
						.getSemesterTaken();
				if (comparison == blank)
				{
					// adds the course to the semesterSchecule
					addACourseToSemesterSchedule(
							getCourseFromCourseName(box.getName()), summer2018);
					getCourseFromCourseName(box.getName()).setSemesterTaken(
							summer2018);
					gui.getJEditorPane(summer2018).setText(
							getSemester(summer2018).getSemesterSchedule()
									.printSchedule());
					gui.repaint();
				} else if (comparison != summer2018)
				{
					Semester old = getCourseFromCourseName(box.getName())
							.getSemesterTaken();
					removeACourseFromSemesterSchedule(
							getCourseFromCourseName(box.getName()),
							getCourseFromCourseName(box.getName())
									.getSemesterTaken());
					gui.getJEditorPane(old).setText(
							getSemester(old).getSemesterSchedule()
									.printSchedule());
					// adds the course to the semesterSchecule
					addACourseToSemesterSchedule(
							getCourseFromCourseName(box.getName()), summer2018);
					getCourseFromCourseName(box.getName()).setSemesterTaken(
							summer2018);
					gui.getJEditorPane(summer2018).setText(
							getSemester(summer2018).getSemesterSchedule()
									.printSchedule());
					gui.repaint();
				}
			} else if (selectedSemester.equals("Fall2018"))
			{
				Semester comparison = getCourseFromCourseName(box.getName())
						.getSemesterTaken();
				if (comparison == blank)
				{
					// adds the course to the semesterSchecule
					addACourseToSemesterSchedule(
							getCourseFromCourseName(box.getName()), fall2018);
					getCourseFromCourseName(box.getName()).setSemesterTaken(
							fall2018);
					gui.getJEditorPane(fall2018).setText(
							getSemester(fall2018).getSemesterSchedule()
									.printSchedule());
					gui.repaint();
				} else if (comparison != fall2018)
				{
					Semester old = getCourseFromCourseName(box.getName())
							.getSemesterTaken();
					removeACourseFromSemesterSchedule(
							getCourseFromCourseName(box.getName()),
							getCourseFromCourseName(box.getName())
									.getSemesterTaken());
					gui.getJEditorPane(old).setText(
							getSemester(old).getSemesterSchedule()
									.printSchedule());
					// adds the course to the semesterSchecule
					addACourseToSemesterSchedule(
							getCourseFromCourseName(box.getName()), fall2018);
					getCourseFromCourseName(box.getName()).setSemesterTaken(
							fall2018);
					gui.getJEditorPane(fall2018).setText(
							getSemester(fall2018).getSemesterSchedule()
									.printSchedule());
					gui.repaint();
				}
			}

			if (selectedSemester.equals("Spring2019"))
			{
				Semester comparison = getCourseFromCourseName(box.getName())
						.getSemesterTaken();
				if (comparison == blank)
				{
					// adds the course to the semesterSchecule
					addACourseToSemesterSchedule(
							getCourseFromCourseName(box.getName()), spring2019);
					getCourseFromCourseName(box.getName()).setSemesterTaken(
							spring2019);
					gui.getJEditorPane(spring2019).setText(
							getSemester(spring2019).getSemesterSchedule()
									.printSchedule());
					gui.repaint();
				} else if (comparison != spring2019)
				{
					Semester old = getCourseFromCourseName(box.getName())
							.getSemesterTaken();
					removeACourseFromSemesterSchedule(
							getCourseFromCourseName(box.getName()),
							getCourseFromCourseName(box.getName())
									.getSemesterTaken());
					gui.getJEditorPane(old).setText(
							getSemester(old).getSemesterSchedule()
									.printSchedule());
					// adds the course to the semesterSchecule
					addACourseToSemesterSchedule(
							getCourseFromCourseName(box.getName()), spring2019);
					getCourseFromCourseName(box.getName()).setSemesterTaken(
							spring2019);
					gui.getJEditorPane(spring2019).setText(
							getSemester(spring2019).getSemesterSchedule()
									.printSchedule());
					gui.repaint();
				}
			} else if (selectedSemester.equals("Summer2019"))
			{
				Semester comparison = getCourseFromCourseName(box.getName())
						.getSemesterTaken();
				if (comparison == blank)
				{
					// adds the course to the semesterSchecule
					addACourseToSemesterSchedule(
							getCourseFromCourseName(box.getName()), summer2019);
					getCourseFromCourseName(box.getName()).setSemesterTaken(
							summer2019);
					gui.getJEditorPane(summer2019).setText(
							getSemester(summer2019).getSemesterSchedule()
									.printSchedule());
					gui.repaint();
				} else if (comparison != summer2019)
				{
					Semester old = getCourseFromCourseName(box.getName())
							.getSemesterTaken();
					removeACourseFromSemesterSchedule(
							getCourseFromCourseName(box.getName()),
							getCourseFromCourseName(box.getName())
									.getSemesterTaken());
					gui.getJEditorPane(old).setText(
							getSemester(old).getSemesterSchedule()
									.printSchedule());
					// adds the course to the semesterSchecule
					addACourseToSemesterSchedule(
							getCourseFromCourseName(box.getName()), summer2019);
					getCourseFromCourseName(box.getName()).setSemesterTaken(
							summer2019);
					gui.getJEditorPane(summer2019).setText(
							getSemester(summer2019).getSemesterSchedule()
									.printSchedule());
					gui.repaint();
				}
			} else if (selectedSemester.equals("Fall2019"))
			{
				Semester comparison = getCourseFromCourseName(box.getName())
						.getSemesterTaken();
				if (comparison == blank)
				{
					// adds the course to the semesterSchecule
					addACourseToSemesterSchedule(
							getCourseFromCourseName(box.getName()), fall2019);
					getCourseFromCourseName(box.getName()).setSemesterTaken(
							fall2019);
					gui.getJEditorPane(fall2019).setText(
							getSemester(fall2019).getSemesterSchedule()
									.printSchedule());
					gui.repaint();
				} else if (comparison != fall2019)
				{
					Semester old = getCourseFromCourseName(box.getName())
							.getSemesterTaken();
					removeACourseFromSemesterSchedule(
							getCourseFromCourseName(box.getName()),
							getCourseFromCourseName(box.getName())
									.getSemesterTaken());
					gui.getJEditorPane(old).setText(
							getSemester(old).getSemesterSchedule()
									.printSchedule());
					// adds the course to the semesterSchecule
					addACourseToSemesterSchedule(
							getCourseFromCourseName(box.getName()), fall2019);
					getCourseFromCourseName(box.getName()).setSemesterTaken(
							fall2019);
					gui.getJEditorPane(fall2019).setText(
							getSemester(fall2019).getSemesterSchedule()
									.printSchedule());
					gui.repaint();
				}
			}

			if (selectedSemester.equals("Spring2020"))
			{
				Semester comparison = getCourseFromCourseName(box.getName())
						.getSemesterTaken();
				if (comparison == blank)
				{
					// adds the course to the semesterSchecule
					addACourseToSemesterSchedule(
							getCourseFromCourseName(box.getName()), spring2020);
					getCourseFromCourseName(box.getName()).setSemesterTaken(
							spring2020);
					gui.getJEditorPane(spring2020).setText(
							getSemester(spring2020).getSemesterSchedule()
									.printSchedule());
					gui.repaint();
				} else if (comparison != spring2020)
				{
					Semester old = getCourseFromCourseName(box.getName())
							.getSemesterTaken();
					removeACourseFromSemesterSchedule(
							getCourseFromCourseName(box.getName()),
							getCourseFromCourseName(box.getName())
									.getSemesterTaken());
					gui.getJEditorPane(old).setText(
							getSemester(old).getSemesterSchedule()
									.printSchedule());
					// adds the course to the semesterSchecule
					addACourseToSemesterSchedule(
							getCourseFromCourseName(box.getName()), spring2020);
					getCourseFromCourseName(box.getName()).setSemesterTaken(
							spring2020);
					gui.getJEditorPane(spring2020).setText(
							getSemester(spring2020).getSemesterSchedule()
									.printSchedule());
					gui.repaint();
				}
			}
		}

		if (e.getSource() instanceof JButton)
		{
			if (checkFullMajorStatusRequirements() == true)
			{
				if (coreqCheck() == true)
				{
					if (checkPrereqs() == true)
					{
						JOptionPane.showMessageDialog(gui,
								"This schedule works!");
					}
				}
			} else
			{
				System.out.println("There are some errors with this schedule.");
			}
		}
	}

	private boolean checkFullMajorStatusRequirements()
	{
		HashSet<Course> classesTakenBeforeCS2420 = getAnyClassesTakenBeforeCS2420();
		Boolean result = checkIfTheyRequireFullMajorStatus(classesTakenBeforeCS2420);
		return result;
	}

	private boolean checkIfTheyRequireFullMajorStatus(
			HashSet<Course> classesTakenBeforeCS2420)
	{
		for (Course c : classesTakenBeforeCS2420)
		{
			if (c.requiresFullMajorStatus() == true)
			{
				JOptionPane
						.showMessageDialog(
								gui,
								"Course, "
										+ c.getFullCourseTitle()
										+ ", requires "
										+ "full major status. CS2420 is taken after this course, therefore, "
										+ "can't be in full major status.");
			}
		}
		return true;

	}

	private HashSet<Course> getAnyClassesTakenBeforeCS2420()
	{
		HashSet<Course> classesTakenBeforeThen = new HashSet<Course>();
		classesTakenBeforeThen = getClassesTakenTillProposedSemester(cs2420
				.getSemesterTaken());
		return classesTakenBeforeThen;
	}

	private boolean coreqCheck()
	{
		if (coreqAlsoTakenThisSemester() == true || coReqArleadyTaken() == true)
		{
			return true;
		}
		return false;
	}

	private boolean coReqArleadyTaken()
	{
		HashSet<Course> classesWithCoreqs = findAllClassesWithCoreqs();
		for (Course course : classesWithCoreqs)
		{
			HashSet<Course> coursesCoreqs = course.getCoreqs();
			for (Course coReqs : coursesCoreqs)
			{
				Semester coReqSem = coReqs.getSemesterTaken();
				Semester courseSem = course.getSemesterTaken();
				if (coReqSem.getYear() > courseSem.getYear())
					return false;
				else if (coReqSem.getYear() < courseSem.getYear())
					return true;
				else if (coReqSem.getYear() == courseSem.getYear())
				{
					if (coReqSem.getSeason() == "Spring")
					{
						if (courseSem.getSeason() == "Summer"
								|| courseSem.getSeason() == "Fall")
							return true;
						else
							return false;
					} else if (coReqSem.getSeason() == "Summer")
					{
						if (courseSem.getSeason() == "Spring")
							return false;
						else
							return true;
					} else
					{
						if (courseSem.getSeason() == "Fall")
							return true;
						else
							return false;
					}
				}
			}
		}
		return false;
	}

	private boolean coreqAlsoTakenThisSemester()
	{
		HashSet<Course> coursesWithCoreqs = findAllClassesWithCoreqs();
		for (Course c : coursesWithCoreqs)
		{
			System.out.println("Course, " + c.getFullCourseTitle()
					+ ", has corequisites.");
			if (classTakenThisSemesterWithCoreqs(c) != true)
			{
				return false;
			}
		}
		return true;
	}

	/*
	 * Returns true if class is being taken with it's coreqs this semester
	 */
	private boolean classTakenThisSemesterWithCoreqs(Course c)
	{
		HashSet<Course> coursesTakenThisSemester = c.getSemesterTaken()
				.getSemesterSchedule().getThisSemestersCourses();
		// for(Course c2 : coursesTakenThisSemester)
		// {
		// System.out.println("Courses being taken during the " +
		// c.getSemesterTaken().getFormattedName() + " semeseter: " +
		// c2.getFullCourseTitle());
		for (Course c3 : c.getCoreqs())
		{
			if (!coursesTakenThisSemester.contains(c3))
			{
				System.out.println(c.getFullCourseTitle()
						+ "'s co-requisite course " + c3.getFullCourseTitle()
						+ "was not found "
						+ "in the list of courses being taken during the "
						+ c.getSemesterTaken().getFormattedName()
						+ " semester.");
				return false;
			}
		}
		// }
		return true;
	}

	private HashSet<Course> findAllClassesWithCoreqs()
	{
		HashSet<Course> set = new HashSet<Course>();
		for (Course c : coursesLeft)
		{
			if (c.getCoreqs() != null)
			{
				set.add(c);
			}
		}
		for (Course c2 : set)
		{
			System.out.println("Course with co-requisites: "
					+ c2.getFullCourseTitle());
		}
		return set;
	}

	private boolean checkPrereqs()
	{
		try
		{
			HashSet<Course> withPrereqs = findCoursesWithPrereqs();
			for (Course c : withPrereqs)
			{
				System.out.println("Class with prereqs: "
						+ c.getFullCourseTitle());
			}
			for (Course c : withPrereqs)
			{
				try
				{
					HashSet<Course> classesTakenTillTargetSem = getClassesTakenTillProposedSemester(c
							.getSemesterTaken());
					HashSet<Course> coursesPrereqs = c.getPrereqs();
					for (Course prerequisite : coursesPrereqs)
					{
						System.out.println("Current course: "
								+ prerequisite.getFullCourseTitle());
						if (!classesTakenTillTargetSem.contains(prerequisite))
						{
							JOptionPane
									.showMessageDialog(
											gui,
											"Prerequisite course "
													+ prerequisite
															.getFullCourseTitle()
													+ " not found in classes taken up until target "
													+ "semester for target course "
													+ c.getFullCourseTitle()
													+ ".");
							return false;
						}
					}
				} catch (NullPointerException e)
				{
					System.out.println("There are no prereqs for "
							+ c.getCourseTitle() + " up until "
							+ c.getSemesterTaken() + " semester.");
				}
			}
		} catch (NullPointerException e)
		{
			System.out.println("No courses with prereqs selected.");
		}
		return true;
	}

	private HashSet<Course> getClassesTakenTillProposedSemester(
			Semester proposedSemester)
	{
		HashSet<Course> coursesTakenSoFar = new HashSet<Course>();
		int index = getTargetSemIndex(proposedSemester);
		for (int i = 0; i < index; i++)
		{
			coursesTakenSoFar.addAll((semesters[i].getSemesterSchedule()
					.getThisSemestersCourses()));
			// for testing purposes only
		}
		for (Course c : coursesTakenSoFar)
		{
			System.out.println("Class taken prior to target semester: "
					+ c.getFullCourseTitle());
		}
		return coursesTakenSoFar;
	}

	/**
	 * Working!
	 * 
	 * @return
	 */
	private HashSet<Course> findCoursesWithPrereqs()
	{
		HashSet<Course> coursesWithPrereqs = new HashSet<Course>();
		for (Course c : coursesLeft)
		{
			try
			{
				HashSet<Course> temp = c.getPrereqs();
				for (Course c3 : temp)
					System.out.println("Item in list of all possible prereqs: "
							+ c3.getFullCourseTitle());
			} catch (NullPointerException e)
			{
				continue;
			}
			if (c.getPrereqs() != null)
			{
				coursesWithPrereqs.add(c);
			} else
				continue;
		}
		return coursesWithPrereqs;
	}

	private int getTargetSemIndex(Semester semester)
	{
		int count = 0;
		if (semester.getSeason().equals("Choose semester"))
		{
			// after testing update with this line:
			// JOptionPane.showMessageDialogue("One or more classes have drop down menus that have not been set to a semester.");
			// throw new IllegalArgumentException();
			return 0;
		}
		while (count < semesters.length)
		{
			if (semester != semesters[count])
			{
				count++;
			} else
			{
				return count;
			}
		}
		return count;
	}
}
