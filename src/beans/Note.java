package beans;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Note
{
    private int noteId;
    private String email;
    private String title;
    private String content;
    private String pictures;
    private int cityId;
    private int resortId;
    private int up;
    private int down;
    private Timestamp editTime;
    private int state;

    @Id
    @Column(name = "NoteID", nullable = false)
    public int getNoteId()
    {
        return noteId;
    }

    public void setNoteId(int noteId)
    {
        this.noteId = noteId;
    }

    @Basic
    @Column(name = "Email", nullable = false, length = 100)
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Basic
    @Column(name = "Title", nullable = false, length = 200)
    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    @Basic
    @Column(name = "Content", nullable = false, length = 2147483647)
    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    @Basic
    @Column(name = "Pictures", nullable = true, length = 2147483647)
    public String getPictures()
    {
        return pictures;
    }

    public void setPictures(String pictures)
    {
        this.pictures = pictures;
    }

    @Basic
    @Column(name = "CityID", nullable = false)
    public int getCityId()
    {
        return cityId;
    }

    public void setCityId(int cityId)
    {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "ResortID", nullable = false)
    public int getResortId()
    {
        return resortId;
    }

    public void setResortId(int resortId)
    {
        this.resortId = resortId;
    }

    @Basic
    @Column(name = "Up", nullable = false)
    public int getUp()
    {
        return up;
    }

    public void setUp(int up)
    {
        this.up = up;
    }

    @Basic
    @Column(name = "Down", nullable = false)
    public int getDown()
    {
        return down;
    }

    public void setDown(int down)
    {
        this.down = down;
    }

    @Basic
    @Column(name = "EditTime", nullable = false)
    public Timestamp getEditTime()
    {
        return editTime;
    }

    public void setEditTime(Timestamp editTime)
    {
        this.editTime = editTime;
    }

    @Basic
    @Column(name = "State", nullable = false)
    public int getState()
    {
        return state;
    }

    public void setState(int state)
    {
        this.state = state;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return noteId == note.noteId &&
                cityId == note.cityId &&
                resortId == note.resortId &&
                up == note.up &&
                down == note.down &&
                state == note.state &&
                Objects.equals(email, note.email) &&
                Objects.equals(title, note.title) &&
                Objects.equals(content, note.content) &&
                Objects.equals(pictures, note.pictures) &&
                Objects.equals(editTime, note.editTime);
    }

    @Override
    public int hashCode()
    {

        return Objects.hash(noteId, email, title, content, pictures, cityId, resortId, up, down, editTime, state);
    }

    @Override
    public String toString()
    {
        return "Note{" +
                "noteId=" + noteId +
                ", email='" + email + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", pictures='" + pictures + '\'' +
                ", cityId=" + cityId +
                ", resortId=" + resortId +
                ", up=" + up +
                ", down=" + down +
                ", editTime=" + editTime +
                ", state=" + state +
                '}';
    }
}
